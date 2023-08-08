package com.github.throyer.todoapp.utils;

import javax.swing.UnsupportedLookAndFeelException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UIUtils {
    public static void lookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException exception) {
            log.info("error on select look and feel", exception);
        }
    }
}
