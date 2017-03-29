package com.Iniebiyo;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Iniebiyo Joshua on 3/24/2017.
 */
//This program recommend Agile or Waterfall for designing software.
public class AgileOrWaterfall extends JFrame{
    private JPanel rootPanel;
    private JTextField projectname;
    private JCheckBox deadlinesInput;
    private JCheckBox experienceInput;
    private JCheckBox integrationInput;
    private JCheckBox earlyWorkingModelsInput;
    private JButton quitButton;
    private JTextField programmersText;
    private JButton recommendButton;
    private JCheckBox qualitiyControlInput;
    private JLabel message;

    private boolean deadlines;
    private boolean experiences;
    private boolean integration;
    private boolean earlyWorkingModels;
    private boolean qaulityControl;
    private boolean isProgrammer;

    public AgileOrWaterfall() {
        super("Agile or Waterfall");
        //Set the contents of the window to be the rootPanel Jpanel.
        setContentPane(rootPanel);
        pack(); //Add the components to the window.
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the size - user wil be able to reset the size.
        setSize(new Dimension(660,500));

        //Waterfall is designed for projects with fixed schedules, milestones, and deadlines
        deadlinesInput.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                deadlines = deadlinesInput.isSelected();
            }
        });
        //Agile requires programmers who have experience in design, integration, and testing, as well as coding.
        experienceInput.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                experiences = experienceInput.isSelected();
            }
        });
        //A benefit of Agile is early integration of components
        integrationInput.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                integration = integrationInput.isSelected();
            }
        });

        // Another benefit of Agile is having an early working prototype
        earlyWorkingModelsInput.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                earlyWorkingModels = earlyWorkingModelsInput.isSelected();
            }
        });

        qualitiyControlInput.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                qaulityControl = qualitiyControlInput.isSelected();
            }
        });

        recommendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String programmers = programmersText.getText();
                String projectName = projectname.getText();
                updateResults(projectName,programmers);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(AgileOrWaterfall.this,
                        "Are you sure you want to quit?",
                        "Quit",JOptionPane.OK_CANCEL_OPTION);
                if(quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults(String project,String programmers){
        int noOfProgrammers = Integer.parseInt(programmers);

        //Agile is best for smaller teams.
        if(noOfProgrammers<=30){
            isProgrammer = true;
        }else{
            isProgrammer = false;
        }
        String results = (isProgrammer && integration && !deadlines && !experiences &&!qaulityControl && !earlyWorkingModels)?
                project + " project should use Agile": project + " project should use Waterfall";
        message.setText(results);
    }
}
