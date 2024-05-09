import java.awt.Color;
public class Steganography
{
    public static void main(String[] args)
    {
        //Notice how the picture needs to be created!
        //Don't change the String value in the Picture parameter.
        Picture beach = new Picture("beach.jpg");
        
        beach = testClearLow(beach);
        beach.write("test.png");
        
        Picture source = new Picture("flower1.jpg");
        
        //source = testClearLow(source);
        source.write("test1.png");
        
        Picture secret = new Picture("flower2.jpg");
        
        //secret = testClearLow(secret);
        secret.write("test2.png");

        Picture revealed = revealPicture(beach);
        

        Picture dookie = new Picture("dookie.jpg");
        //dookie.explore();
        
        Picture dookiefriend = new Picture("dookiefriend.jpg");
        

        System.out.println(canHide(dookie, dookiefriend));
        Picture newDookie = hidePicture(dookie, dookie);
        Picture revealDookie = revealPicture(newDookie);
        revealDookie.write("realDookie.png");
        
        Picture filterDookie = filter(dookie);
        filterDookie.write("filterDookie.png");
        /**System.out.println(canHide(source, secret));
        Picture newPicture = hidePicture(source, source);
        Picture revealedPicture = revealPicture(newPicture);
        revealedPicture.write("newPicProof.png");
        */
    }

    /**
    * Clear the lower (rightmost) two bits in a pixel.
    */
    public static void clearLow( Pixel p )
    {
        Color oldColor = p.getColor();
        
        int r = oldColor.getRed();
        int g = oldColor.getGreen();
        int b = oldColor.getBlue();

        r /= 150;
        r *= 150;

        g /= 150;
        g *= 150;

        b /= 150;
        b *= 150;

        p.setColor(new Color(r, g, b));
    }
    
    /**
     * Returns a new Picture object with the lowest two bits of each pixel cleared.
     */

    public static Picture testClearLow(Picture p)
    {
        //To be implemented 
        Picture p2 = new Picture(p);

        p2.getPixels2D();
        Pixel[][] pix = p2.getPixels2D();

        for(int i = 0; i < pix.length; i ++)
        {
            for(int j = 0; j < pix[0].length; j ++)
            {
                Pixel x = pix[i][j];
                clearLow(x);

            } 
        }

        return p2;
    }
    
    public static Picture revealPicture(Picture p)
    {
        Picture copy = new Picture(p);
        Pixel[][] pix_new = copy.getPixels2D();
        Pixel[][] pix_old = p.getPixels2D();

        for(int r = 0; r < pix_new.length; r++)
        {
            for(int c = 0; c < pix_new[0].length; c++)
            {
                Pixel x = pix_new[r][c];

                Pixel x_old = pix_old[r][c];
                Color c_old = x_old.getColor();

                int oldR = c_old.getRed();
                int oldG = c_old.getGreen();
                int oldB = c_old.getBlue();

                int newR = oldR % 4 * 64;
                int newG = oldG % 4 * 64;
                int newB = oldB % 4 * 64;

                x.setRed(newR);
                x.setGreen(newG);
                x.setBlue(newB);

            }
        }

        return copy;
    }
    public static boolean canHide(Picture source, Picture secret)
    {
        if(source.getWidth() == secret.getWidth() && source.getHeight() == secret.getHeight())
        {
            return true;
        }else{
            return false;
        }

    }

    public static Picture hidePicture(Picture source, Picture secret)
    {
        Picture hiddenPicture = new Picture(secret);
        Pixel[][] hiddenPicture_new = hiddenPicture.getPixels2D();
        Pixel[][] hiddenPicture_old = source.getPixels2D();

        for(int r = 0; r < hiddenPicture_new.length; r++)
        {
            for(int c = 0; c < hiddenPicture_new[0].length; c++)
            {
                Pixel x = hiddenPicture_new[r][c];
                Color xColor = x.getColor();

                Pixel x_old = hiddenPicture_old[r][c];
                Color c_old = x_old.getColor();

                int oldR = c_old.getRed();
                int oldG = c_old.getGreen();
                int oldB = c_old.getBlue();

                int oldR_secret = xColor.getRed();
                int oldG_secret = xColor.getGreen();
                int oldB_secret = xColor.getBlue();

                int newRModified = oldR / 4 * 4;
                int newGModified = oldG / 4 * 4;
                int newBModified = oldB / 4 * 4;

                int newR_secret = oldR_secret / 64;
                int newG_secret = oldG_secret / 64;
                int newB_secret = oldB_secret / 64;

                newRModified = newRModified + newR_secret;
                newGModified = newGModified + newG_secret;
                newBModified = newBModified + newB_secret;

                x.setRed(newRModified);
                x.setGreen(newGModified);
                x.setBlue(newBModified);
            }
        }

        return hiddenPicture;
    }
    
    public static Picture filter(Picture source)
    {
        Picture hiddenPicture = new Picture(source);
        Pixel[][] hiddenPicture_new = hiddenPicture.getPixels2D();

        for(int r = 0; r < hiddenPicture_new.length; r++)
        {
            for(int c = 0; c < hiddenPicture_new[0].length; c++)
            {
                Pixel x = hiddenPicture_new[r][c];
                Color x_Color = x.getColor();

                int oldR_secret = x_Color.getRed();
                int oldG_secret = x_Color.getGreen();
                int oldB_secret = x_Color.getBlue();

                int newR = oldR_secret * 6;
                int newG = oldG_secret * 2;
                int newB = oldB_secret * 4;

                x.setRed(newR);
                x.setGreen(newG);
                x.setBlue(newB);
            }
        }
        return hiddenPicture;
    }
}
