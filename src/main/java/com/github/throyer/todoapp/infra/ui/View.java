package com.github.throyer.todoapp.infra.ui;

import javax.swing.JFrame;

public abstract class View extends JFrame {
    public void onOpen() { };
    public void onClose() { };
}
