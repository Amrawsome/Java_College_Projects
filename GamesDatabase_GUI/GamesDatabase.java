/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdatabase;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author stephen
 */
public class GamesDatabase extends JPanel {//start class    
    public GamesDatabase() {//start GamesDatabase
        initComponents();
        if (!Beans.isDesignTime()) {//start if
            entityManager.getTransaction().begin();
        }//end if
    }//end GamesDatabase
   
    static public class DBQueries {//start DBQueries
        
        static String NumberofGames(){//start NumberofGames
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "SELECT COUNT(*) FROM Gamesdetails";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String num = rs1.getString(1);
                    x = num;
                }//end while
                st1.close();
            }//end try   
            catch (SQLException e){//start catch
                System.err.println("Couldn't get number of games, please restart program ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end NumberofGames
        
        static String ActionGenre(){//start ActionGenre
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "SELECT Count(*) FROM Gamesdetails Where GameGenre Like '%Action-%' or GameGenre like 'Action%'";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String ABove8 = rs1.getString(1);
                    x = ABove8;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
                System.err.println("Couldn't get number of games with action genre, please restart program ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end ActionGenre
   
        static String Above(){//start Above
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "Select Count(*) From Gamesdetails where GameRating >8";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String ABove8 = rs1.getString(1);
                    x = ABove8;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
            System.err.println("Coudln't get how many games had a rating above 8 ");
            System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end Above
    
        static String BeforeYear(){//start BeforeYear
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "Select Count(*) FROM Gamesdetails Where GameRelease <2018";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String ABove8 = rs1.getString(1);
                    x = ABove8;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
                System.err.println("Couldn't get how many games released before 2018 ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end BeforeYear
        
        static String GOTY(){//start GOTY
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "Select Count(*) From Gamesdetails where GameoftheYear = True";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String ABove8 = rs1.getString(1);
                    x = ABove8;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
                System.err.println("Couldn't get how many games got a game of the year award ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end GOTY
        
        static String averagePrice(){//start averagePrice
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "Select AVG(GamePriceInEuro) From GamesDetails";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String avgP = rs1.getString(1);
                    x = avgP;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
                System.err.println("Couldn't get the average price of a game ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end averagePrice
        
        static String platformPc (){//start platformPC
            String x = null;
            try{//start try
                String myDriver = "org.apache.derby.jdbc.ClientDriver";
                String myUrl = "jdbc:derby://localhost:1527/GamesDB";
                Connection conn = DriverManager.getConnection(myUrl, "user1", "user1");
                String count = "Select Count(*) From GamesDetails where GameConsoleRelease like '%PC'";
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery(count);
                while (rs1.next()){//start while
                    String platPC = rs1.getString(1);
                    x = platPC;
                }//end while
                st1.close();
            }//end try
            catch (SQLException e){//start catch
                System.err.println("Couldn't get games exclusively released on PC ");
                System.err.println(e.getMessage());
            }//end catch
            return x;
        }//end platformPC
    }//end DBQueries

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("GamesDBPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT g FROM Gamesdetails g");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        gametitleLabel = new javax.swing.JLabel();
        gamegenreLabel = new javax.swing.JLabel();
        gamedeveloperLabel = new javax.swing.JLabel();
        gamereleaseLabel = new javax.swing.JLabel();
        gamepriceineuroLabel = new javax.swing.JLabel();
        gameoftheyearLabel = new javax.swing.JLabel();
        gameconsolereleaseLabel = new javax.swing.JLabel();
        gameratingLabel = new javax.swing.JLabel();
        gametitle = new javax.swing.JTextField();
        gamegenre = new javax.swing.JTextField();
        gamedeveloper = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        releaseYear = new javax.swing.JSlider();
        gotyCB = new javax.swing.JCheckBox();
        gameRating = new javax.swing.JSlider();
        gamePrice = new javax.swing.JTextField();
        platformCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        above8 = new javax.swing.JTextArea();
        goty = new javax.swing.JTextArea();
        numberOfGames = new javax.swing.JTextArea();
        actionGenre = new javax.swing.JTextArea();
        avgPrice = new javax.swing.JTextArea();
        beforeYear = new javax.swing.JTextArea();
        platformPC = new javax.swing.JTextArea();
        Statistics = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        FullName = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        Email = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Helpsubmit = new javax.swing.JButton();
        Helpclear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Message = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setName("jPanel1"); // NOI18N

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        masterTable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        masterTable.setToolTipText("This will display the database");
        masterTable.setName("masterTable"); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gametitle}"));
        columnBinding.setColumnName("Game Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gamegenre}"));
        columnBinding.setColumnName("Game Genre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gamedeveloper}"));
        columnBinding.setColumnName("Game Developer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gamerelease}"));
        columnBinding.setColumnName("Game Release(Year)");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gamepriceineuro}"));
        columnBinding.setColumnName("Game Price In Euro");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gameoftheyear}"));
        columnBinding.setColumnName("Game Of The Year");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gameconsolerelease}"));
        columnBinding.setColumnName("Platform Release");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gamerating}"));
        columnBinding.setColumnName("Game Rating");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        gametitleLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gametitleLabel.setText("Game Title:");
        gametitleLabel.setName("gametitleLabel"); // NOI18N

        gamegenreLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gamegenreLabel.setText("Game Genre:");
        gamegenreLabel.setName("gamegenreLabel"); // NOI18N

        gamedeveloperLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gamedeveloperLabel.setText("Game Developer:");
        gamedeveloperLabel.setName("gamedeveloperLabel"); // NOI18N

        gamereleaseLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gamereleaseLabel.setText("Game Release:");
        gamereleaseLabel.setName("gamereleaseLabel"); // NOI18N

        gamepriceineuroLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gamepriceineuroLabel.setText("Game Price In Euro:");
        gamepriceineuroLabel.setName("gamepriceineuroLabel"); // NOI18N

        gameoftheyearLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gameoftheyearLabel.setText("Game Of The Year:");
        gameoftheyearLabel.setName("gameoftheyearLabel"); // NOI18N

        gameconsolereleaseLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gameconsolereleaseLabel.setText("Platform Availability:");
        gameconsolereleaseLabel.setName("gameconsolereleaseLabel"); // NOI18N

        gameratingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        gameratingLabel.setText("Game Rating:");
        gameratingLabel.setName("gameratingLabel"); // NOI18N

        gametitle.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gametitle.setToolTipText("Enter Game Title Here");
        gametitle.setName("gametitle"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gametitle}"), gametitle, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gametitle, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gamegenre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gamegenre.setToolTipText("Enter Game Genre Here");
        gamegenre.setName("gamegenre"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gamegenre}"), gamegenre, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gamegenre, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gamedeveloper.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gamedeveloper.setToolTipText("Enter The Game Developer Here");
        gamedeveloper.setName("gamedeveloper"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gamedeveloper}"), gamedeveloper, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gamedeveloper, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.setToolTipText("Click To Save New Information To Database");
        saveButton.setName("saveButton"); // NOI18N
        saveButton.addActionListener(formListener);

        refreshButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("Click To Refresh Database");
        refreshButton.setName("refreshButton"); // NOI18N
        refreshButton.addActionListener(formListener);

        newButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        newButton.setText("New");
        newButton.setToolTipText("Click To Add New Row For Information");
        newButton.setName("newButton"); // NOI18N
        newButton.addActionListener(formListener);

        deleteButton.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setToolTipText("Click To Delete Selected Row");
        deleteButton.setName("deleteButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        releaseYear.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        releaseYear.setMajorTickSpacing(1);
        releaseYear.setMaximum(2021);
        releaseYear.setMinimum(1992);
        releaseYear.setMinorTickSpacing(1);
        releaseYear.setPaintLabels(true);
        releaseYear.setPaintTicks(true);
        releaseYear.setToolTipText("Drag Slider To The Year The Game Released");
        releaseYear.setName("releaseYear"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gamerelease}"), releaseYear, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(2006);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), releaseYear, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gotyCB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gotyCB.setText("Did It Win A Game Of The Year Award?");
        gotyCB.setToolTipText("Check Box If Game Won The Award");
        gotyCB.setName("gotyCB"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gameoftheyear}"), gotyCB, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        binding.setSourceNullValue(false);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gotyCB, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gotyCB.addActionListener(formListener);

        gameRating.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gameRating.setMajorTickSpacing(1);
        gameRating.setMaximum(10);
        gameRating.setMinorTickSpacing(1);
        gameRating.setPaintLabels(true);
        gameRating.setPaintTicks(true);
        gameRating.setToolTipText("Drag To Choose Relevant Game Rating ");
        gameRating.setName("gameRating"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gamerating}"), gameRating, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(5);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gameRating, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gamePrice.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        gamePrice.setToolTipText("Enter Price Of Game Here");
        gamePrice.setName("gamePrice"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gamepriceineuro}"), gamePrice, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceNullValue("0");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), gamePrice, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        gamePrice.addActionListener(formListener);

        platformCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        platformCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PC", "PS4", "Xbox One", "PC,PS4", "PC,Xbox One", "PS4,Xbox One", "PC,Xbox One,PS4" }));
        platformCombo.setToolTipText("Click To Choose Platform Availability ");
        platformCombo.setName("platformCombo"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.gameconsolerelease}"), platformCombo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        binding.setSourceNullValue(null);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), platformCombo, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        platformCombo.addActionListener(formListener);

        jLabel8.setFont(new java.awt.Font("Calibri Light", 1, 38)); // NOI18N
        jLabel8.setText("Games Database");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 0), 10));
        jLabel8.setName("jLabel8"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(gameratingLabel))
                                .addComponent(gameoftheyearLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gamepriceineuroLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(gameconsolereleaseLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(156, 156, 156)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(156, 156, 156)
                                .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(152, 152, 152)
                                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(platformCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(782, 782, 782))
                            .addComponent(gotyCB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gameRating, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gamePrice)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gamedeveloperLabel)
                                .addComponent(gamegenreLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gametitleLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(gamereleaseLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gamedeveloper, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gamegenre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(releaseYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(gametitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterScrollPane))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gametitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gametitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamegenre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gamegenreLabel))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamedeveloper, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gamedeveloperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(gamereleaseLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(releaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gamepriceineuroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gotyCB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameoftheyearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platformCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameconsolereleaseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(gameratingLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(gameRating, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        platformCombo.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Games Database", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setName("jPanel2"); // NOI18N

        above8.setEditable(false);
        above8.setColumns(20);
        above8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        above8.setRows(5);
        above8.setToolTipText("This Will Show How Many Games Got A Score Above 8");
        above8.setName("above8"); // NOI18N

        goty.setEditable(false);
        goty.setColumns(20);
        goty.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        goty.setRows(5);
        goty.setToolTipText("Shows The Amount Of Games That Won The Game Of The Year Award");
        goty.setName("goty"); // NOI18N

        numberOfGames.setEditable(false);
        numberOfGames.setColumns(20);
        numberOfGames.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        numberOfGames.setRows(5);
        numberOfGames.setToolTipText("This Will Show The Total Number Of Games In The Database");
        numberOfGames.setName("numberOfGames"); // NOI18N

        actionGenre.setEditable(false);
        actionGenre.setColumns(20);
        actionGenre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        actionGenre.setRows(5);
        actionGenre.setToolTipText("Shows The Number Of Games That Are In The Action Genre");
        actionGenre.setName("actionGenre"); // NOI18N

        avgPrice.setEditable(false);
        avgPrice.setColumns(20);
        avgPrice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        avgPrice.setRows(5);
        avgPrice.setToolTipText("Shows The Average Price Of A Game");
        avgPrice.setName("avgPrice"); // NOI18N

        beforeYear.setEditable(false);
        beforeYear.setColumns(20);
        beforeYear.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        beforeYear.setRows(5);
        beforeYear.setToolTipText("Shows How Many Of The Games Released Before 2018");
        beforeYear.setName("beforeYear"); // NOI18N

        platformPC.setEditable(false);
        platformPC.setColumns(20);
        platformPC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        platformPC.setRows(5);
        platformPC.setToolTipText("Shows The Amount Of Games That Came Out Exclusively On PC");
        platformPC.setName("platformPC"); // NOI18N

        Statistics.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        Statistics.setText("Statistics");
        Statistics.setToolTipText("This Button Will Show And Update Statistics In The Boxes");
        Statistics.setName("Statistics"); // NOI18N
        Statistics.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setText("Total Number Of Games In The Database:");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel2.setText("Number of Games In The Action Genre:");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel3.setText("How many Games Released Before 2018:");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel4.setText("This Is The Average Price Of A Game In Euros:");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel5.setText("How Many Games Have Won A Game Of The Year Award:");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel6.setText("How Many Games Are Exclsuively PC Release Only:");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel7.setText("How Many Games Scored A Rating Above 8:");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 38)); // NOI18N
        jLabel9.setText("Statistics");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153), 10));
        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(593, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 573, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(actionGenre, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                                .addComponent(goty, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(platformPC, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(above8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(beforeYear, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(avgPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numberOfGames)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numberOfGames, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(actionGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beforeYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avgPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goty, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(platformPC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(above8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(Statistics, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Statistics", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel11.setText("Full Name:");
        jLabel11.setToolTipText("Please enter your full name in the box to the right :) ");
        jLabel11.setName("jLabel11"); // NOI18N

        FullName.setColumns(20);
        FullName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        FullName.setLineWrap(true);
        FullName.setRows(5);
        FullName.setToolTipText("Please Enter Full Name Here");
        FullName.setWrapStyleWord(true);
        FullName.setName("FullName"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel12.setText("Email Address:");
        jLabel12.setToolTipText("Please enter your email address in the box to the right :) ");
        jLabel12.setName("jLabel12"); // NOI18N

        Email.setColumns(20);
        Email.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Email.setLineWrap(true);
        Email.setRows(5);
        Email.setToolTipText("Please Enter Email Address Here");
        Email.setWrapStyleWord(true);
        Email.setName("Email"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel13.setText("Message:");
        jLabel13.setToolTipText("Please enter the message in the box to the right :) ");
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 38)); // NOI18N
        jLabel14.setText("Help Desk");
        jLabel14.setBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 10, true));
        jLabel14.setName("jLabel14"); // NOI18N

        Helpsubmit.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Helpsubmit.setText("Submit");
        Helpsubmit.setToolTipText("This Will Submit The Information From The 3 Boxes ");
        Helpsubmit.setName("Helpsubmit"); // NOI18N
        Helpsubmit.addMouseListener(formListener);

        Helpclear.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        Helpclear.setText("Clear");
        Helpclear.setToolTipText("This Will Clear The 3 Boxes");
        Helpclear.setName("Helpclear"); // NOI18N
        Helpclear.addMouseListener(formListener);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        Message.setColumns(20);
        Message.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Message.setRows(5);
        Message.setToolTipText("Please Enter Your Message Here");
        Message.setName("Message"); // NOI18N
        jScrollPane1.setViewportView(Message);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Helpclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(314, 314, 314)
                        .addComponent(Helpsubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(Email)
                    .addComponent(FullName))
                .addGap(178, 178, 178))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(119, 119, 119)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(FullName, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Helpclear, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Helpsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13))
                .addGap(241, 241, 241))
        );

        jTabbedPane1.addTab("Help", jPanel3);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel26.setFont(new java.awt.Font("Calibri Light", 1, 38)); // NOI18N
        jLabel26.setText("Logout");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.red, 10));
        jLabel26.setName("jLabel26"); // NOI18N

        Exit.setFont(new java.awt.Font("Calibri", 0, 40)); // NOI18N
        Exit.setText("Logout");
        Exit.setToolTipText("Press this to logout");
        Exit.setName("Exit"); // NOI18N
        Exit.addMouseListener(formListener);
        Exit.addActionListener(formListener);

        jLabel25.setName("jLabel25"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(461, 461, 461)
                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(460, 460, 460))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(12, 12, 12)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(416, 416, 416))
        );

        jTabbedPane1.addTab("Exit", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1472, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                GamesDatabase.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                GamesDatabase.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                GamesDatabase.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                GamesDatabase.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == gotyCB) {
                GamesDatabase.this.gotyCBActionPerformed(evt);
            }
            else if (evt.getSource() == gamePrice) {
                GamesDatabase.this.gamePriceActionPerformed(evt);
            }
            else if (evt.getSource() == platformCombo) {
                GamesDatabase.this.platformComboActionPerformed(evt);
            }
            else if (evt.getSource() == Statistics) {
                GamesDatabase.this.StatisticsActionPerformed(evt);
            }
            else if (evt.getSource() == Exit) {
                GamesDatabase.this.ExitActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == Helpsubmit) {
                GamesDatabase.this.HelpsubmitMouseClicked(evt);
            }
            else if (evt.getSource() == Helpclear) {
                GamesDatabase.this.HelpclearMouseClicked(evt);
            }
            else if (evt.getSource() == Exit) {
                GamesDatabase.this.ExitMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog( Exit,"Confirm if you Want to Exit","Games Database",
        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void HelpclearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpclearMouseClicked
        FullName.setText("");
        Email.setText("");
        Message.setText("");
    }//GEN-LAST:event_HelpclearMouseClicked

    private void HelpsubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpsubmitMouseClicked
        // TODO add your handling code here:if (Email=="@")
        try{//start try
            String emai1 = Email.getText();
            String Emailcheck = "\\b[A-Za-z0-9._%+-]+\\@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
            Pattern p = Pattern.compile(Emailcheck);
            Matcher m = p.matcher(emai1);
            String name = FullName.getText();
            String Namecheck;
            Namecheck = "\\b[0-9._%+-;@#~!£$%^&*=,.<>/?`¬]{1,100}\\b";
            Pattern d = Pattern.compile(Namecheck);
            Matcher f = d.matcher(name);
            if(f.find()|FullName.getText().isEmpty() | Email.getText().isEmpty()|Message.getText().isEmpty() ){//start if
                JOptionPane.showMessageDialog(null, "Please Enter What is Required in Each Box.");
            } //end if
            else  {//start else
                if(m.find()){//start if
                    JOptionPane.showMessageDialog(null,"Thank you for the message we will reply as soon as possible.");
                }//end if
            }//end else
        }//end try
        catch(HeadlessException e){//start catch
            JOptionPane.showMessageDialog(null, "Please Only Use Letter and Numbers Where Asked"+e);
        }//end catch
    }//GEN-LAST:event_HelpsubmitMouseClicked

    private void StatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatisticsActionPerformed
        // TODO add your handling code here:
        try{//start try
            String totalabove = DBQueries.Above();
            above8.setText(totalabove);
            String totalnum = DBQueries.NumberofGames();
            numberOfGames.setText(totalnum);
            String totalaction = DBQueries.ActionGenre();
            actionGenre.setText(totalaction);
            String totalbefore = DBQueries.BeforeYear();
            beforeYear.setText(totalbefore);
            String totalgoty = DBQueries.GOTY();
            goty.setText(totalgoty);
            String averagePrice = DBQueries.averagePrice();
            avgPrice.setText(averagePrice);
            String hmPC = DBQueries.platformPc();
            platformPC.setText(hmPC);
        }//end try
        catch(Exception e){//start catch
            JOptionPane.showMessageDialog(null, "Statistics Button Is Not Working"+e);
        }//end catch
    }//GEN-LAST:event_StatisticsActionPerformed

    private void platformComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platformComboActionPerformed

    }//GEN-LAST:event_platformComboActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try{//start try
            saveButton.setEnabled(true);
            int[] selected = masterTable.getSelectedRows();
            List<gamesdatabase.Gamesdetails> toRemove = new ArrayList<gamesdatabase.Gamesdetails>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {//start for
                gamesdatabase.Gamesdetails g = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                toRemove.add(g);
                entityManager.remove(g);
            }//end for 
            list.removeAll(toRemove);
        }//end try
        catch (Exception e){//start catch
            JOptionPane.showMessageDialog(null, "Could not delete! "+e);
        }//end catch
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        try{//start try
            JOptionPane.showMessageDialog(null, "Please Make Sure Game Title Is Always Different To Ones Shown In The Column. Also Please Remember You Can Update Rows By Clicking On Them Instead Of Making A New One.");
            newButton.setEnabled(false);
            gamesdatabase.Gamesdetails g = new gamesdatabase.Gamesdetails();
            entityManager.persist(g);
            list.add(g);
            int row = list.size() - 1;
            masterTable.setRowSelectionInterval(row, row);
            masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        }//end try
        catch(HeadlessException e){//start catch
            JOptionPane.showMessageDialog(null, "New Is Not Working "+e);
        }//end catch
    }//GEN-LAST:event_newButtonActionPerformed

    @SuppressWarnings("unchecked")
    
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        try{//start try
            newButton.setEnabled(true);
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            java.util.Collection data = query.getResultList();
            for (Object entity : data) {//start for
                entityManager.refresh(entity);
            }//end for
            list.clear();
            list.addAll(data);
        }//end try
        catch(Exception e){//start catch
            JOptionPane.showMessageDialog(null, "Refresh Is Not Working"+e);
        }//end catch
    }//GEN-LAST:event_refreshButtonActionPerformed
 
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {//start try
            newButton.setEnabled(true);
            if(gametitle.getText().isEmpty()|gamegenre.getText().isEmpty()|gamePrice.getText().isEmpty()|gamedeveloper.getText().isEmpty()){//start if
                JOptionPane.showMessageDialog(null, "Please Make Sure All Areas Are Filled In And Refresh Before Trying Again");
                entityManager.getTransaction().rollback();
                entityManager.getTransaction().begin();
                java.util.Collection data = query.getResultList();
                for (Object entity : data) {//start for
                    entityManager.refresh(entity);
                }//end for
                list.clear();
                list.addAll(data);
            }//end if
            else{//start else
                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();
                entityManager.getTransaction().begin();
                List<gamesdatabase.Gamesdetails> merged = new ArrayList<gamesdatabase.Gamesdetails>(list.size());
                for (gamesdatabase.Gamesdetails g : list) {//start for
                    merged.add(entityManager.merge(g));
                }//end for
                list.clear();
                list.addAll(merged);
            }//end else
        }//end try 
        catch (RollbackException rex) {//start catch
              JOptionPane.showMessageDialog(null, "Save is not working"+rex);
        }//end catch
    }//GEN-LAST:event_saveButtonActionPerformed

    private void gamePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamePriceActionPerformed

    }//GEN-LAST:event_gamePriceActionPerformed

    private void gotyCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotyCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gotyCBActionPerformed

   
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JTextArea Email;
    javax.swing.JButton Exit;
    javax.swing.JTextArea FullName;
    javax.swing.JButton Helpclear;
    javax.swing.JButton Helpsubmit;
    javax.swing.JTextArea Message;
    javax.swing.JButton Statistics;
    javax.swing.JTextArea above8;
    javax.swing.JTextArea actionGenre;
    javax.swing.JTextArea avgPrice;
    javax.swing.JTextArea beforeYear;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    javax.swing.JTextField gamePrice;
    javax.swing.JSlider gameRating;
    javax.swing.JLabel gameconsolereleaseLabel;
    javax.swing.JTextField gamedeveloper;
    javax.swing.JLabel gamedeveloperLabel;
    javax.swing.JTextField gamegenre;
    javax.swing.JLabel gamegenreLabel;
    javax.swing.JLabel gameoftheyearLabel;
    javax.swing.JLabel gamepriceineuroLabel;
    javax.swing.JLabel gameratingLabel;
    javax.swing.JLabel gamereleaseLabel;
    javax.swing.JTextField gametitle;
    javax.swing.JLabel gametitleLabel;
    javax.swing.JTextArea goty;
    javax.swing.JCheckBox gotyCB;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel25;
    javax.swing.JLabel jLabel26;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTabbedPane jTabbedPane1;
    private java.util.List<gamesdatabase.Gamesdetails> list;
    javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    javax.swing.JTextArea numberOfGames;
    javax.swing.JComboBox<String> platformCombo;
    javax.swing.JTextArea platformPC;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    javax.swing.JSlider releaseYear;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {//start main
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamesDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamesDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamesDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamesDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {//start Runnable
            public void run() {//start run
                JFrame frame = new JFrame();
                frame.setContentPane(new GamesDatabase());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }//end run
        });
    }//end Runnable
    
}//end class
