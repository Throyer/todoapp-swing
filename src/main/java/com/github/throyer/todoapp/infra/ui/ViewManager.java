package com.github.throyer.todoapp.infra.ui;

import static com.github.throyer.todoapp.infra.ui.Views.CREATE_TASK;
import com.github.throyer.todoapp.views.Categories;
import com.github.throyer.todoapp.views.CreateCategory;
import com.github.throyer.todoapp.views.CreateTask;
import com.github.throyer.todoapp.views.CreateUser;
import com.github.throyer.todoapp.views.Login;
import com.github.throyer.todoapp.views.Tasks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ViewManager {
    private static ApplicationContext context;

    public ViewManager(ApplicationContext context) {
        ViewManager.context = context;
    }

    public static void navigate(Views from, Views to) {
        log.info("navigating from {} to {}", from.name(), to.name());
        
        var frameFrom = frame(from);
        var frameTo = frame(to);
        
        frameFrom.onClose();
        frameFrom.setVisible(false);
        
        frameTo.onOpen();
        frameTo.setVisible(true);
    }
        
    private static View frame(Views view) {
        return  switch (view) {
            case LOGIN -> context.getBean(Login.class);
            case CREATE_USER -> context.getBean(CreateUser.class);
            case CREATE_TASK -> context.getBean(CreateTask.class);
            case CREATE_CATEGORY -> context.getBean(CreateCategory.class);
            case TASK_MANAGER -> context.getBean(Tasks.class);
            case CATEGORY_MANAGER -> context.getBean(Categories.class);
        };
    }
}
