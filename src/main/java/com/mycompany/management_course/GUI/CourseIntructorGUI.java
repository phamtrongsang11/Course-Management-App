package com.mycompany.management_course.GUI;

import com.mycompany.management_course.GUI.CourseGUI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import com.mycompany.management_course.DAL.CourseIntructor;
import com.mycompany.management_course.BLL.CourseIntructorBLL;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class CourseIntructorGUI extends javax.swing.JFrame {

    private ArrayList<CourseIntructor> CourseIntructorList = new ArrayList<>();
    private ArrayList<CourseIntructor> CourseIntructorSearchList = new ArrayList<>();
    private ArrayList<CourseIntructor> TitleList = new ArrayList<>();
    private ArrayList<CourseIntructor> TeacherList = new ArrayList<>();
    private CourseIntructorBLL CourseIntructorBUS = new CourseIntructorBLL();
    private CourseIntructor courseintructor = new CourseIntructor();
    private String[] titleOnsiteTable = {"CourseID", "Title", "Name"};
    private DefaultTableModel model = new DefaultTableModel();
    private int page = 1;
    private int numRecord = 5;
    private int IDperson;
    /**
     * Creates new form CourseIntructorGUI
     */
    public CourseIntructorGUI() {
        initComponents();
        loadAllCourse();
        setValueTocbbxTeacher(TeacherList);
        setValueToCombobox(TitleList);
        CourseBtn.setSelected(true);
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        loadCourseByPage(page);
    }
    public void loadAllCourse() {
        CourseIntructorList = CourseIntructorBUS.readcourseintructor();
        TitleList = CourseIntructorBUS.readALLTitle();
        TeacherList = CourseIntructorBUS.readAllTeacher();
//        setValueToTable(CourseIntructorList);
        
        
        
    }
    
    public void setValueToCombobox(ArrayList<CourseIntructor> TitleList)
    {
        for(int i = 0; i<TitleList.size();i++)
        {
            cbbxTitle.addItem(TitleList.get(i).getTitle());
        }
    }
    
    
    
    
    
    public void check(int titleID, int personID)
    {
       for(int i =0; i<CourseIntructorList.size();i++)
       {
           if(CourseIntructorList.get(i).getCourseID() == titleID && CourseIntructorList.get(i).getPersonID() == personID)
           {
               btnAdd.setEnabled(false);
               btnDelete.setEnabled(true);
               break;
          
           }
           else
           {
              btnAdd.setEnabled(true);
              btnDelete.setEnabled(false);
           }
       }
    }
    public void setValueTocbbxTeacher(ArrayList<CourseIntructor> TeacherList)
    {
        for(int i = 0; i<TeacherList.size();i++)
        {
            String nameteacher = TeacherList.get(i).getLastname() +" " + TeacherList.get(i).getFirstname()+ "-" + TeacherList.get(i).getPersonID();
            TeacherCbbx.addItem(nameteacher);
        }
    }
    public void setValueToTable(ArrayList<CourseIntructor> CourseIntructorList) {
        DefaultTableModel model = (DefaultTableModel) courseIntructorTable.getModel();
        model.setRowCount(0);
        for (int i = 0; i < CourseIntructorList.size(); i++) {
            Vector row = new Vector();
            row.add(CourseIntructorList.get(i).getCourseID());
            row.add(CourseIntructorList.get(i).getTitle());
            String name = CourseIntructorList.get(i).getLastname()+" "+CourseIntructorList.get(i).getFirstname() + "-" +  CourseIntructorList.get(i).getPersonID();
            row.add(name);
            model.addRow(row);

        }
        courseIntructorTable.setModel(model);
        customDesign();
    }
    public void customDesign() {

        courseIntructorTable.setRowHeight(30);
        setColumnWidth(courseIntructorTable, widthHeaderList);
    }
    
    public void loadCourseByPage(int page) {

        try {
                setValueToTable(CourseIntructorBUS.ReadCourseIntructorByNumPage(page, numRecord));
          
        } catch (SQLException ex) {
            Logger.getLogger(CourseGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void setColumnWidth(JTable tbl, int[] width) {
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        TableColumnModel columnModel = tbl.getColumnModel();
        for (int i = 0; i < width.length; i++) {
            if (i < columnModel.getColumnCount()) {
                columnModel.getColumn(i).setMaxWidth(width[i]);
            } else {
                break;
            }
        }

    }
    private int[] widthHeaderList = {100, 350, 350};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lbPage = new javax.swing.JLabel();
        pAsign = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseIntructorTable = new javax.swing.JTable();
        PersonBtn = new javax.swing.JRadioButton();
        CourseBtn = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnPrev1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        abc = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtTeacher = new javax.swing.JLabel();
        TeacherCbbx = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        cbbxTitle = new javax.swing.JComboBox<>();
        txtCourse = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(23, 49, 74));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnPrev.setBackground(new java.awt.Color(0, 117, 217));
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("Prev");
        btnPrev.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevMouseClicked(evt);
            }
        });
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 117, 217));
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText("Next");
        btnNext.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lbPage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPage.setForeground(new java.awt.Color(255, 255, 255));
        lbPage.setText("1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPage))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 700));

        pAsign.setBackground(new java.awt.Color(34, 63, 90));

        jPanel2.setBackground(new java.awt.Color(34, 63, 90));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COURSE-INTRUCTOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(34, 63, 90));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        courseIntructorTable.setAutoCreateRowSorter(true);
        courseIntructorTable.setBackground(new java.awt.Color(23, 49, 74));
        courseIntructorTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        courseIntructorTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        courseIntructorTable.setForeground(new java.awt.Color(255, 255, 255));
        courseIntructorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course ID", "Course Name", "Teacher Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        courseIntructorTable.setGridColor(new java.awt.Color(255, 255, 255));
        courseIntructorTable.setRowHeight(30);
        courseIntructorTable.setSelectionBackground(new java.awt.Color(43, 79, 112));
        courseIntructorTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        courseIntructorTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseIntructorTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        courseIntructorTable.setShowGrid(true);
        courseIntructorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseIntructorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(courseIntructorTable);

        buttonGroup1.add(PersonBtn);
        PersonBtn.setForeground(new java.awt.Color(255, 255, 255));
        PersonBtn.setText("Person");
        PersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(CourseBtn);
        CourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        CourseBtn.setText("Course");

        jPanel5.setBackground(new java.awt.Color(23, 49, 74));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        btnPrev1.setBackground(new java.awt.Color(0, 117, 217));
        btnPrev1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrev1.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev1.setText("Prev");
        btnPrev1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnPrev1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrev1MouseClicked(evt);
            }
        });
        btnPrev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev1ActionPerformed(evt);
            }
        });

        btnNext1.setBackground(new java.awt.Color(0, 117, 217));
        btnNext1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNext1.setForeground(new java.awt.Color(255, 255, 255));
        btnNext1.setText("Next");
        btnNext1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnNext1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNext1MouseClicked(evt);
            }
        });
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        abc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        abc.setForeground(new java.awt.Color(255, 255, 255));
        abc.setText("1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abc))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(23, 49, 74));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255)), "Asign Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(23, 49, 74));

        jPanel8.setBackground(new java.awt.Color(23, 49, 74));

        txtTeacher.setBackground(new java.awt.Color(255, 255, 255));
        txtTeacher.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtTeacher.setForeground(new java.awt.Color(255, 255, 255));
        txtTeacher.setText("Teacher");

        TeacherCbbx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherCbbxMouseClicked(evt);
            }
        });
        TeacherCbbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeacherCbbxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txtTeacher)
                .addGap(30, 30, 30)
                .addComponent(TeacherCbbx, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTeacher)
                    .addComponent(TeacherCbbx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TeacherCbbx, txtTeacher});

        jPanel7.setBackground(new java.awt.Color(23, 49, 74));

        cbbxTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbxTitleMouseClicked(evt);
            }
        });
        cbbxTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbxTitleActionPerformed(evt);
            }
        });

        txtCourse.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtCourse.setForeground(new java.awt.Color(255, 255, 255));
        txtCourse.setText("Course");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCourse)
                .addGap(30, 30, 30)
                .addComponent(cbbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourse)
                    .addComponent(cbbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbbxTitle, txtCourse});

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(23, 49, 74));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        btnDelete.setBackground(new java.awt.Color(0, 117, 217));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 117, 217));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Update");
        btnEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefesh.setBackground(new java.awt.Color(0, 117, 217));
        btnRefesh.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRefesh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefesh.setText("Reload");
        btnRefesh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 117, 217));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(34, 63, 90));

        btnSearch.setBackground(new java.awt.Color(0, 117, 217));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSearch, txtSearch});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(CourseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PersonBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PersonBtn)
                            .addComponent(CourseBtn))
                        .addGap(313, 313, 313))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pAsignLayout = new javax.swing.GroupLayout(pAsign);
        pAsign.setLayout(pAsignLayout);
        pAsignLayout.setHorizontalGroup(
            pAsignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAsignLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 812, Short.MAX_VALUE)
        );
        pAsignLayout.setVerticalGroup(
            pAsignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAsignLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pAsign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pAsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbxTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbxTitleActionPerformed
            String A = (String)cbbxTitle.getSelectedItem();
            String B = (String)TeacherCbbx.getSelectedItem();
            String[] C = B.split("-",2);
            int  E = C.length;
            String PersonID = C[E-1];
            int CourseID = CourseIntructorBUS.getIDbyTitle(A);
            check(CourseID,Integer.parseInt(PersonID));
            
            
    }//GEN-LAST:event_cbbxTitleActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String a = (String)cbbxTitle.getSelectedItem();
        String b = (String)TeacherCbbx.getSelectedItem();
        String[] c = b.split("-",2);
        int  e = c.length;
        String PersonID = c[e-1];
        int CourseID = CourseIntructorBUS.getIDbyTitle(a);
        CourseIntructor addNew = new CourseIntructor();
        addNew.setCourseID(CourseID);
        addNew.setPersonID(Integer.parseInt(PersonID));
        int add = CourseIntructorBUS.insertCourseIntructor(addNew);
        if (add == 1)
        {
           JOptionPane.showMessageDialog(this, "Add Successfully", "Notify", JOptionPane.INFORMATION_MESSAGE);
           loadCourseByPage(page);
           

        }
        else {
                JOptionPane.showMessageDialog(this, "Error, Inserted Fail", "Notify", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void TeacherCbbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeacherCbbxActionPerformed

            String a = (String)cbbxTitle.getSelectedItem();
            String b = (String)TeacherCbbx.getSelectedItem();
            String[] c = b.split("-",2);
            int  e = c.length;
            String PersonID = c[e-1];
            int CourseID = CourseIntructorBUS.getIDbyTitle(a);
            check(CourseID,Integer.parseInt(PersonID));
    }//GEN-LAST:event_TeacherCbbxActionPerformed

    public void delete(int CourseID, int PersonID)
    {
        int delete = CourseIntructorBUS.deleteCourseIntructor(CourseID, PersonID);
        if (delete == 1)
        {
           JOptionPane.showMessageDialog(this, "Delete Successfully", "Notify", JOptionPane.INFORMATION_MESSAGE);
           loadCourseByPage(page);
        }
        else {
                JOptionPane.showMessageDialog(this, "Error, Delete Fail", "Notify", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String a = (String)cbbxTitle.getSelectedItem();
        String b = (String)TeacherCbbx.getSelectedItem();
        String[] c = b.split("-",2);
        int  e = c.length;
        String PersonID = c[e-1];
        int CourseID = CourseIntructorBUS.getIDbyTitle(a);
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure want to delete it", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION)
        {
            delete(CourseID,Integer.parseInt(PersonID));
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    private void courseIntructorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseIntructorTableMouseClicked
        int i = courseIntructorTable.getSelectedRow();
        if(i != -1)
        {
            cbbxTitle.setSelectedItem(courseIntructorTable.getModel().getValueAt(i, 1).toString());
            TeacherCbbx.setSelectedItem(courseIntructorTable.getModel().getValueAt(i, 2).toString());
            cbbxTitle.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);
            String b = (String)TeacherCbbx.getSelectedItem();
            String[] c = b.split("-",2);
            int  e = c.length;
            this.IDperson = Integer.parseInt(c[e-1]);
           
            
            
        }
    }//GEN-LAST:event_courseIntructorTableMouseClicked

    private void cbbxTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbxTitleMouseClicked
           
    }//GEN-LAST:event_cbbxTitleMouseClicked

    public void update(int courseID, int personID, int oddPersonID)
    {
        courseintructor.setCourseID(courseID);
        courseintructor.setPersonID(personID);
        int a = CourseIntructorBUS.updateCourseIntructor(courseintructor,oddPersonID);
        if (a == 1)
        {
           JOptionPane.showMessageDialog(this, "Update Successfully", "Notify", JOptionPane.INFORMATION_MESSAGE);
           loadCourseByPage(page);


        }
        else {
                JOptionPane.showMessageDialog(this, "Error, Update Fail", "Notify", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String a = (String)cbbxTitle.getSelectedItem();
        String b = (String)TeacherCbbx.getSelectedItem();
        String[] c = b.split("-",2);
        boolean flag=true;
        int  e = c.length;
        String PersonID = c[e-1];
        int CourseID = CourseIntructorBUS.getIDbyTitle(a);
        //System.out.println(this.IDperson+" "+ PersonID+" "+CourseID);
        for(int i =0; i<CourseIntructorList.size();i++)
       {
           if(CourseIntructorList.get(i).getCourseID() == CourseID && CourseIntructorList.get(i).getPersonID() == Integer.parseInt(PersonID))
           {
               JOptionPane.showMessageDialog(rootPane, "Update fail");
               flag=false;
               break;
          
           }
           else
           {
//              jButton1.setEnabled(true);
//              jButton3.setEnabled(false);
           }
       }
        if(flag)
            update(CourseID, Integer.parseInt(PersonID),this.IDperson);
        
     
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        courseIntructorTable.removeAll();
        txtSearch.setText("");
        cbbxTitle.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        String A = (String)cbbxTitle.getSelectedItem();
            String B = (String)TeacherCbbx.getSelectedItem();
            String[] C = B.split("-",2);
            int  E = C.length;
            String PersonID = C[E-1];
            int CourseID = CourseIntructorBUS.getIDbyTitle(A);
            check(CourseID,Integer.parseInt(PersonID));
        loadAllCourse();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void TeacherCbbxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherCbbxMouseClicked
        
    }//GEN-LAST:event_TeacherCbbxMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
    
    public JPanel getPanel(){
        return pAsign;
    }
    
    
    
    public void Search(String name)
    {
        
//        if(CourseBtn.isSelected())
//        {
//            CourseIntructorSearchList = CourseIntructorBUS.searchCourse(name);
//            DefaultTableModel model = (DefaultTableModel) courseIntructorTable.getModel();
//            model.setRowCount(0);
//            for (int i = 0; i < CourseIntructorSearchList.size(); i++) {
//            Vector row = new Vector();
//            row.add(CourseIntructorSearchList.get(i).getCourseID());
//            row.add(CourseIntructorSearchList.get(i).getTitle());
//            String name1 = CourseIntructorSearchList.get(i).getLastname()+" "+CourseIntructorSearchList.get(i).getFirstname() + "-" +  CourseIntructorSearchList.get(i).getPersonID();
//            row.add(name1);
//            model.addRow(row);
//
//        }
//        courseIntructorTable.setModel(model);
//        customDesign();
//            loadCourseByPage(page);
//        }
//        else
//        {
//            CourseIntructorSearchList = CourseIntructorBUS.searchPerson(name);
//            DefaultTableModel model = (DefaultTableModel) courseIntructorTable.getModel();
//            model.setRowCount(0);
//            for (int i = 0; i < CourseIntructorSearchList.size(); i++) {
//            Vector row = new Vector();
//            row.add(CourseIntructorSearchList.get(i).getCourseID());
//            row.add(CourseIntructorSearchList.get(i).getTitle());
//            String name1 = CourseIntructorSearchList.get(i).getLastname()+" "+CourseIntructorSearchList.get(i).getFirstname() + "-" +  CourseIntructorSearchList.get(i).getPersonID();
//            row.add(name1);
//            model.addRow(row);
//
//        }
//        courseIntructorTable.setModel(model);
//        customDesign();
//        }
        try {
            if(CourseBtn.isSelected())
            {
              
                setValueToTable(CourseIntructorBUS.ReadByCourseByNumPage(page,numRecord,name));
            }
            else
            {
                
                setValueToTable(CourseIntructorBUS.ReadByPersonByNumPage(page,numRecord,name));
            }
        } catch (Exception e) {
        }
    }
    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked

        String name = txtSearch.getText();
        Search(name);
        
    }//GEN-LAST:event_btnSearchMouseClicked

    private void PersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PersonBtnActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked

        if (page == 1) {
            JOptionPane.showMessageDialog(this, "You can't move to the previous page because this is first page", "Notify", JOptionPane.INFORMATION_MESSAGE);
        } else {
            page -= 1;
            lbPage.setText(page + "");
            //loadCourseByType(page);

        }
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    public int getMaxPage(int size) {
        int maxPage = 0;
        return size % numRecord != 0 ? (maxPage = size / numRecord + 1) : (maxPage = size / numRecord);
    }
    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        

        if ( page + 1 > this.getMaxPage(CourseIntructorBUS.getSizeList())) {
            JOptionPane.showMessageDialog(this, "You can't move to the next page because this is last page", "Notify", JOptionPane.INFORMATION_MESSAGE);
        } else {
            page += 1;
            lbPage.setText(page + "");
            //loadCourseByType(page);
        }

    }//GEN-LAST:event_btnNextMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrev1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrev1MouseClicked

        if (page == 1) {
            JOptionPane.showMessageDialog(this, "You can't move to the previous page because this is first page", "Notify", JOptionPane.INFORMATION_MESSAGE);
        } else {
            page -= 1;
            abc.setText(page + "");
            loadCourseByPage(page);

        }
    }//GEN-LAST:event_btnPrev1MouseClicked

    private void btnPrev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrev1ActionPerformed

    private void btnNext1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNext1MouseClicked
        

        if ( page + 1 > this.getMaxPage(CourseIntructorList.size())) {
            JOptionPane.showMessageDialog(this, "You can't move to the next page because this is last page", "Notify", JOptionPane.INFORMATION_MESSAGE);
        } else {
            page += 1;
            abc.setText(page + "");
            loadCourseByPage(page);
        }

    }//GEN-LAST:event_btnNext1MouseClicked

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNext1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseIntructorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseIntructorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton CourseBtn;
    private javax.swing.JRadioButton PersonBtn;
    private javax.swing.JComboBox<String> TeacherCbbx;
    private javax.swing.JLabel abc;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnPrev1;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbxTitle;
    private javax.swing.JTable courseIntructorTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbPage;
    private javax.swing.JPanel pAsign;
    private javax.swing.JLabel txtCourse;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtTeacher;
    // End of variables declaration//GEN-END:variables

}
