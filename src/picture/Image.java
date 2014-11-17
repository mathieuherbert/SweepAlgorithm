package picture;

import model.Possibility;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gutii on 08/11/14.
 */
public class Image {

    final static int BLACK = 0;
    final static int WHITE = 16777215;
    final static int MULTIPLICATEUR = 10;

    private List<List<ColoredPossibility>> coloredPossibilities;
    private List<BufferedImage> listImage;
    private ImageWriter gifWriter;
    private ImageWriteParam imageWriteParam;
    private IIOMetadata imageMetaData;

    /**
     * Constructor Image
     * @param possibilities
     */
    public Image(List<List<Possibility>> possibilities) {
        this.coloredPossibilities = new ArrayList<List<ColoredPossibility>>();
        List<Integer> listeCouleur = new ArrayList<Integer>();
        for(int i = 0; i< possibilities.get(0).size();i++){
            listeCouleur.add((int) ((Math.random()*256 * 65536) + (Math.random()*256 * 256) + (Math.random()*256)));
        }
        for(List<Possibility> listPossibility : possibilities){
            List<ColoredPossibility> listColoredPossibilities = new ArrayList<ColoredPossibility>();

            for(int i = 0 ; i<listPossibility.size();i++){
                listColoredPossibilities.add(new ColoredPossibility(listPossibility.get(i),listeCouleur.get(i)));
            }

            this.coloredPossibilities.add(listColoredPossibilities);
        }
    }

    /**
     * Image Generator
     * @param folderName
     * @param domainWidth
     * @param domainHeight
     * @throws IOException
     */
    public void generateImage(String folderName,int domainWidth, int domainHeight) throws IOException {
        File dir = new File("Images/"+folderName);
        dir.mkdir();
        String fileName = "./Images/"+folderName+"/possibility_";
        BufferedImage grid = new BufferedImage(domainWidth * MULTIPLICATEUR * 12 + 2,domainHeight * MULTIPLICATEUR * 12 + 2,BufferedImage.TYPE_INT_RGB);
        initialisation(grid);
        saveImage(grid,"./Images/"+folderName+"/grid");
        this.listImage = new ArrayList<BufferedImage>();
        initialiserGif(500, folderName);

        for(int i = 0; i < this.coloredPossibilities.size(); i++){
            BufferedImage image = openGrid(folderName);
            for(ColoredPossibility coloredPossibility : this.coloredPossibilities.get(i)){
                this.drawPossibility(coloredPossibility, image);
            }
            //saveImage(image,fileName+i);
            writeToSequence(image);
        }
        gifWriter.endWriteSequence();
}

    /**
     * Initialisation de la grille
     * @param image
     * @return
     */
    private static BufferedImage initialisation(BufferedImage image){
        for(int i = 0 ; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                // Contour de la grille
                if(i == 0 || i == 1 || i == image.getWidth()-1 || i == image.getWidth()-2
                        ||j == 0 || j == 1 || j == image.getHeight()-2 || j== image.getHeight()-1 ){
                    image.setRGB(i,j,BLACK);
                }
                // Contour intérieurs de la grille
                else if(i%120 == 0 || i%120 == 1 || j%120 ==0 || j%120 == 1){
                    image.setRGB(i,j,BLACK);
                }
                // Case de la grille
                else{
                    image.setRGB(i,j,WHITE);
                }
            }
        }
        return image;
    }

    /**
     * Dessine les possibilités dans une image
     * @param coloredPossibility
     * @param image
     * @return
     */
    private BufferedImage drawPossibility(ColoredPossibility coloredPossibility,BufferedImage image){
        int x = coloredPossibility.getPossibility().getD1Value() * MULTIPLICATEUR * 12 +  2 ;
        int y = image.getHeight() - coloredPossibility.getPossibility().getD2Value() * MULTIPLICATEUR * 12 -  3 ;
        int width = coloredPossibility.getPossibility().getD1Width() * MULTIPLICATEUR * 12 - 2 ;
        int height = coloredPossibility.getPossibility().getD2Width() * MULTIPLICATEUR * 12 - 2 ;

        for(int i = x; i < x + width;i++){
            for(int j = y; j > y - height ;j--){
                image.setRGB(i, j, coloredPossibility.getRgb());
            }
        }
        return image;
    }

    /**
     * Sauvegarde de l'image
     * @param image
     * @param fileName
     */
    private void saveImage(BufferedImage image, String fileName){
        File outputfile = new File(fileName+".jpg");
        try {
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ouverture de la grille
     * @param folderName
     * @return
     */
    private BufferedImage openGrid(String folderName){
        try {
            return ImageIO.read(new File("./Images/" + folderName + "/grid.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Initialisation du GIF
     * @param timeBetweenFramesMS
     * @param folderName
     * @throws IOException
     */
    private void initialiserGif(int timeBetweenFramesMS, String folderName) throws IOException {
        Iterator<ImageWriter> iter = ImageIO.getImageWritersBySuffix("gif");
        if(!iter.hasNext()) {
            throw new IIOException("No GIF Image Writers Exist");
        } else {
            gifWriter = iter.next();
        }

        imageWriteParam = gifWriter.getDefaultWriteParam();
        ImageTypeSpecifier imageTypeSpecifier =
                ImageTypeSpecifier.createFromBufferedImageType(5);

        // Initialisation des metadatas
        imageMetaData =
                gifWriter.getDefaultImageMetadata(imageTypeSpecifier,
                        imageWriteParam);

        String metaFormatName = imageMetaData.getNativeMetadataFormatName();

        IIOMetadataNode root = (IIOMetadataNode)
                imageMetaData.getAsTree(metaFormatName);

        IIOMetadataNode graphicsControlExtensionNode = getNode(
                root,
                "GraphicControlExtension");

        graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
        graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute(
                "transparentColorFlag",
                "FALSE");
        graphicsControlExtensionNode.setAttribute(
                "delayTime",
                Integer.toString(timeBetweenFramesMS / 10));
        graphicsControlExtensionNode.setAttribute(
                "transparentColorIndex",
                "0");

        IIOMetadataNode commentsNode = getNode(root, "CommentExtensions");
        commentsNode.setAttribute("CommentExtension", "Created by MAH");

        IIOMetadataNode appEntensionsNode = getNode(
                root,
                "ApplicationExtensions");

        IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");

        child.setAttribute("applicationID", "NETSCAPE");
        child.setAttribute("authenticationCode", "2.0");

        child.setUserObject(new byte[]{ 0x1, (byte) (1 & 0xFF), (byte)
                ((1 >> 8) & 0xFF)});
        appEntensionsNode.appendChild(child);

        imageMetaData.setFromTree(metaFormatName, root);

        FileImageOutputStream outputStream = new FileImageOutputStream(new File("./Images/"+folderName+"/possibilities.gif"));
        gifWriter.setOutput(outputStream);

        gifWriter.prepareWriteSequence(null);
    }

    /**
     * Récupération des metadatas
     * @param rootNode
     * @param nodeName
     * @return
     */
    private static IIOMetadataNode getNode(
            IIOMetadataNode rootNode,
            String nodeName) {
        int nNodes = rootNode.getLength();
        for (int i = 0; i < nNodes; i++) {
            if (rootNode.item(i).getNodeName().compareToIgnoreCase(nodeName)
                    == 0) {
                return((IIOMetadataNode) rootNode.item(i));
            }
        }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return(node);
    }

    /**
     * Ecriture des tiles du GIF
     * @param img
     * @throws IOException
     */
    public void writeToSequence(RenderedImage img) throws IOException {
        gifWriter.writeToSequence(
                new IIOImage(
                        img,
                        null,
                        imageMetaData),
                imageWriteParam);
    }
}
