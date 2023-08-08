package com.github.throyer.todoapp;

import com.github.throyer.todoapp.utils.UIUtils;
import com.github.throyer.todoapp.views.Login;
import java.awt.EventQueue;
import static jiconfont.icons.FontAwesome.getIconFont;
import static jiconfont.swing.IconFontSwing.register;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TodoAppApplication {
    public static void main(String... args) {
        var context = new SpringApplicationBuilder(TodoAppApplication.class)
            .headless(false)
            .run(args);
        
        UIUtils.lookAndFeel();
        
        EventQueue.invokeLater(() -> {
            var screen = context.getBean(Login.class);
            screen.setVisible(true);
        });
    }
    
    static {
        register(getIconFont());
    }
}
