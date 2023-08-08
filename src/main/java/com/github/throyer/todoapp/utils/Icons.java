package com.github.throyer.todoapp.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

public class Icons {
    public static Image toImage(Icon icon) {
        if (isNull(icon)) {
            return null;
        }
        
        if (icon instanceof ImageIcon imageIcon) {
            return imageIcon.getImage();
        }

        int width = requireNonNull(icon.getIconWidth(), "width is null");
        int height = requireNonNull(icon.getIconHeight(), "height is null");
        
        var environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        var device = environment.getDefaultScreenDevice();
        var configuration = device.getDefaultConfiguration();
        var image = configuration.createCompatibleImage(width, height);
        var graphics = image.createGraphics();
        icon.paintIcon(null, graphics, 0, 0);
        graphics.dispose();
        return image;
    }
    
    public static Image image(FontAwesome fontAwesome, int size, Color color) {
        return toImage(icon(fontAwesome, size, color));
    }
    
    public static Icon icon(FontAwesome fontAwesome, int size, Color color) {
        return IconFontSwing.buildIcon(fontAwesome, size, color);
    }
}
