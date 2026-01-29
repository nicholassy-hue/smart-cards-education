package pkg;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Single JFrame app with:
 *  - Menu (grade buttons, arrows, subject buttons)
 *  - Grade7 panel (MainFrame) implemented as a JPanel
 *  - Placeholder panels for other grades / steps / next
 */
public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;

    // Panels
    private JPanel menuPanel;
    private JPanel grade7Panel;
    private JPanel grade7StepsPanel;
    private JPanel grade7aPanel;
    private JPanel grade7aStepsPanel;
    private JPanel grade72bPanel;
    private JPanel grade72bstepsPanel;
    private JPanel grade8Panel;
    private JPanel grade8stepsPanel;
    private JPanel grade8aPanel;
    private JPanel grade8astepsPanel;
    private JPanel grade8bPanel;
    private JPanel grade8bstepsPanel;
    private JPanel grade9Panel;
    private JPanel grade9stepsPanel;
    private JPanel grade9aPanel;
    private JPanel grade9astepsPanel;
    private JPanel grade9bPanel;
    private JPanel grade9bstepsPanel;
    private JPanel grade10Panel;
    private JPanel grade10stepsPanel;
    private JPanel grade7NextPanel;
    private JPanel grade7EnglishPanel;

    // UI state
    private int selectedGrade = 0; // 0 = none, 7/8/9/10 = selected
    private JLabel arro7, arro8, arro9, arro10;
    private JTextField userttf;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1187, 861);

        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        setContentPane(contentPane);

        // Build panels
        menuPanel = createMenuPanel();//menupanel
        grade7Panel = createGrade7Panel();//algebra panel
        grade7StepsPanel = createGrade7stepsPanel();//algebra steps panel
        grade7aPanel=createGrade7aPanel();//adding fractions panel
        grade7aStepsPanel=createGrade7aStepsPanel();// adding fractions steps panel
        grade72bPanel=createGrade72bPanel();//word problems panel
        grade72bstepsPanel=createGrade72bstepsPanel();//word problem steps panel
        grade8Panel = createGrade8Panel();//pythagorean problems panel
        grade8stepsPanel = createGrade8stepsPanel();//pythagorean problem steps panel
        grade8aPanel = createGrade8aPanel();//circumference problem panel
        grade8astepsPanel = createGrade8astepsPanel();//circumference problem steps panel
        grade8bPanel = createGrade8bPanel();//function problem panel
        grade8bstepsPanel = createGrade8bstepsPanel();//function problem steps panel
        grade9Panel = createGrade9Panel();//Statistics panel
        grade9stepsPanel = createGrade9stepsPanel();//Statistics steps panel
        grade9aPanel = createGrade9aPanel();//quadratics x-intercepts panel
        grade9astepsPanel = createGrade9astepsPanel();//quadratics x-intercepts steps panel
        grade9bPanel = createGrade9bPanel();//quadratics roots panel
        grade9bstepsPanel = createGrade9bstepsPanel();//quadratics roots steps panel
        grade10Panel = createGrade10Panel();//polynomial panels
        grade10stepsPanel=createGrade10stepsPanel();//polynomial steps panel       

        // Additional panels for Grade7 flow (steps / next) - placeholders
        
        grade7NextPanel  = createPlaceholderPanel("Grade 7 - Next Question", "/assets/Screenshot 2023-10-27 at 1.58.16 PM.png");
        grade7EnglishPanel = createPlaceholderPanel("Grade 7 - English (placeholder)", "/assets/Screenshot 2023-10-27 at 1.58.16 PM.png");

        // Add to card layout
        contentPane.add(menuPanel, "Menu");
        contentPane.add(grade7Panel, "Grade7");
        contentPane.add(grade7StepsPanel, "Grade7Steps");
        contentPane.add(grade7aPanel,"Grade7a");
        contentPane.add(grade7aStepsPanel,"Grade7aSteps");
        contentPane.add(grade72bPanel,"Grade72bPanel");
        contentPane.add(grade72bstepsPanel,"Grade72bSteps");
        contentPane.add(grade8Panel, "Grade8");
        contentPane.add(grade8stepsPanel, "Grade8Steps");
        contentPane.add(grade8aPanel, "Grade8a");
        contentPane.add(grade8astepsPanel, "Grade8aSteps");
        contentPane.add(grade8bPanel, "Grade8b");
        contentPane.add(grade8bstepsPanel, "Grade8bSteps");
        contentPane.add(grade9Panel, "Grade9");
        contentPane.add(grade9stepsPanel, "Grade9Steps");
        contentPane.add(grade9aPanel, "Grade9a");
        contentPane.add(grade9astepsPanel, "Grade9aSteps");
        contentPane.add(grade9bPanel, "Grade9b");
        contentPane.add(grade9bstepsPanel, "Grade9bSteps");
        contentPane.add(grade10Panel, "Grade10");
        contentPane.add(grade10stepsPanel, "Grade10Steps");
        contentPane.add(grade7NextPanel, "Grade7Next");
        contentPane.add(grade7EnglishPanel, "Grade7_English");
        cardLayout.show(contentPane, "Menu");}

    /** Menu panel (with grade buttons, arrows, subject buttons, background) */
    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(null);

        // Background added first so other components paint on top
 

        // username text field (same place as your original)
        userttf = new JTextField();
        userttf.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
        userttf.setBounds(329, 296, 371, 52);
        panel.add(userttf);

        // Grade buttons (use your assets)
        JButton grd7btn = new JButton(safeIcon("/assets/Screenshot 2023-10-27 at 1.07.45 PM.png"));
        grd7btn.setBounds(344, 384, 96, 80);
        grd7btn.addActionListener(e -> selectGrade(7));
        panel.add(grd7btn);

        JButton grd8btn = new JButton(safeIcon("/assets/Screenshot 2023-10-27 at 1.09.45 PM.png"));
        grd8btn.setBounds(453, 384, 103, 80);
        grd8btn.addActionListener(e -> selectGrade(8));
        panel.add(grd8btn);

        JButton grd9btn = new JButton(safeIcon("/assets/Screenshot 2023-10-27 at 1.11.22 PM.png"));
        grd9btn.setBounds(568, 384, 101, 80);
        grd9btn.addActionListener(e -> selectGrade(9));
        panel.add(grd9btn);

        JButton grd10btn = new JButton(safeIcon("/assets/Screenshot 2023-10-27 at 1.13.29 PM.png"));
        grd10btn.setBounds(693, 384, 96, 80);
        grd10btn.addActionListener(e -> selectGrade(10));
        panel.add(grd10btn);

        // Subject buttons
        JButton engbtn = new JButton(safeIcon("/assets/Screenshot 2023-11-07 at 1.53.34 PM.png"));
        engbtn.setBounds(296, 504, 311, 141);
        engbtn.addActionListener(e -> goToSubject("English"));
        panel.add(engbtn);

        JButton mathbtn = new JButton(safeIcon("/assets/Screenshot 2023-11-07 at 1.56.03 PM.png"));
        mathbtn.setBounds(602, 503, 322, 143);
        mathbtn.addActionListener(e -> goToSubject("Math"));
        panel.add(mathbtn);
     
        arro7 = safeIconLabel("/assets/Screenshot 2023-10-27 at 1.34.28 PM.png", 377, 353, 26, 34);
        arro8 = safeIconLabel("/assets/Screenshot 2023-10-27 at 1.34.28 PM.png", 489, 353, 26, 34);
        arro9 = safeIconLabel("/assets/Screenshot 2023-10-27 at 1.34.28 PM.png", 603, 353, 26, 34);
        arro10 = safeIconLabel("/assets/Screenshot 2023-10-27 at 1.34.28 PM.png", 729, 353, 26, 34);

        if (arro7 != null) { arro7.setVisible(false); panel.add(arro7); }
        if (arro8 != null) { arro8.setVisible(false); panel.add(arro8); }
        if (arro9 != null) { arro9.setVisible(false); panel.add(arro9); }
        if (arro10 != null){ arro10.setVisible(false); panel.add(arro10); }
        
        JLabel background = safeIconLabel("/assets/Screenshot 2023-10-17 at 2.28.37 PM.png", -13, -6, 1198, 789);
        if (background != null) panel.add(background);

        // Arrow indicators (hidden by default)
        return panel;
    }

    
   

    /** Create the Grade 7 panel using your MainFrame code (converted to JPanel) */
        
    private JPanel createGrade7Panel() {
        JPanel panel = new JPanel(null);
        // Back to menu
        JButton menubtn = new JButton("<-- Back to Menu");
        menubtn.setBounds(22, 205, 158, 38);
        menubtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
        panel.setLayout(null);
        panel.add(menubtn);
        

        // Problem label
        JLabel problem = new JLabel("");
        problem.setBounds(303, 453, 600, 40);
        problem.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
        panel.add(problem);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
        lblNewLabel.setBounds(224, 439, 400, 54);
        panel.add(lblNewLabel);
       
        
		
        // Generate button
        JButton generques = new JButton("Generate");
        generques.setBounds(768, 499, 203, 79);
        generques.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
        generques.addActionListener(e -> {
            int a, d, u, i, o;
            do {
                a = (int) (Math.random() * 7) + 1;
                d = (int) (Math.random() * 7) + 1;
                u = (int) (Math.random() * 7) + 1;
                i = (int) (Math.random() * 7) + 1;
                o = (int) (Math.random() * 7) + 1;
            } while (a == i); // ensure a != i

            problem.setText(a + "(x+" + d + ")" + "-" + u + "=" + i + "x" + "-" + o);

            // write to Card.txt
            try (PrintWriter w = new PrintWriter(new FileOutputStream(new File("Card.txt")))) {
                w.println(a);
                w.println(d);
                w.println(u);
                w.println(i);
                w.println(o);
        
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        panel.add(generques);

        
        // Show steps -> switch to Grade7Steps panel
        JButton stepbtn = new JButton("Show steps");
        stepbtn.setBounds(768, 275, 203, 79);
        stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
        stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade7Steps"));
        panel.add(stepbtn);

        // Next question -> switch to Grade7Next panel
        JButton nextbtn = new JButton("Next question");
        nextbtn.setBounds(287, 625, 262, 79);
        nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
        nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade7a"));
        panel.add(nextbtn);

        // Username label (read from file)
        JLabel user1 = new JLabel("");
        user1.setBounds(121, 137, 321, 28);
        panel.add(user1);

        JLabel bg = safeIconLabel("/assets/Screenshot 2023-10-27 at 1.58.16 PM.png", 0, 6, 1165, 772);
        if (bg != null) panel.add(bg);
        
        // load username from file, if present
        try (BufferedReader r = new BufferedReader(new FileReader("Username.txt"))) {
            String user = r.readLine();
            user1.setText(user != null ? user : "");
        } catch (Exception ex) {
            // ignore if missing
        }

        return panel;
    }
   
    private JPanel createGrade7stepsPanel() {
        
    	JPanel panel = new JPanel(null);
        JButton nextbtn = new JButton("Next question");
        nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade7a"));
		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		nextbtn.setBounds(1005, 663, 192, 89);
		panel.add(nextbtn);
				
		
		JLabel vary1 = new JLabel("n");
		vary1.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		vary1.setBounds(668, 329, 30, 39);
		panel.add(vary1);
		
		
		JLabel vary2 = new JLabel("c");
		vary2.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary2.setBounds(765, 387, 43, 39);
		panel.add(vary2);
		
		JLabel vary3 = new JLabel("x");
		vary3.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary3.setBounds(824, 387, 30, 39);
		panel.add(vary3);
		
		JLabel vary4 = new JLabel("a");
		vary4.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary4.setBounds(885, 387, 30, 39);
		panel.add(vary4);
		
		JLabel vary5 = new JLabel("b");
		vary5.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary5.setBounds(964, 387, 30, 39);
		panel.add(vary5);
		
		JLabel vary1b = new JLabel("n");
		vary1b.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary1b.setBounds(689, 387, 30, 39);
		panel.add(vary1b);
		
		JLabel vary6 = new JLabel("");
		vary6.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary6.setBounds(615, 547, 30, 39);
		panel.add(vary6);
		
		JLabel vary7 = new JLabel("");
		vary7.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary7.setBounds(678, 550, 43, 37);
		panel.add(vary7);
		
		JLabel vary8 = new JLabel("0");
		vary8.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary8.setBounds(744, 547, 30, 39);
		panel.add(vary8);
		
		JLabel vary9 = new JLabel("0");
		vary9.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		vary9.setBounds(797, 547, 48, 39);
		panel.add(vary9);
		
		JLabel vary10 = new JLabel("0");
		vary10.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary10.setBounds(542, 619, 22, 26);
		panel.add(vary10);
		
		JLabel vary11 = new JLabel("0");
		vary11.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary11.setBounds(730, 658, 22, 26);
		panel.add(vary11);
		
		JLabel vary12 = new JLabel("0");
		vary12.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary12.setBounds(784, 658, 22, 26);
		panel.add(vary12);
		
		JLabel vary13 = new JLabel("0");
		vary13.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary13.setBounds(840, 658, 22, 26);
		panel.add(vary13);
		
		JLabel vary14 = new JLabel("0");
		vary14.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary14.setBounds(867, 658, 48, 26);
		panel.add(vary14);
		
		JLabel vary15 = new JLabel("0");
		vary15.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary15.setBounds(909, 658, 22, 26);
		panel.add(vary15);
		
		JLabel vary16 = new JLabel("0");
		vary16.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		vary16.setBounds(974, 658, 53, 26);
		panel.add(vary16);
		
		JLabel vary17 = new JLabel("0");
		vary17.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		vary17.setBounds(948, 694, 68, 26);
		panel.add(vary17);
		
		JLabel vary18 = new JLabel("0");
		vary18.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		vary18.setBounds(730, 726, 44, 19);
		panel.add(vary18);
		
		JLabel vary19 = new JLabel("0");
		vary19.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		vary19.setBounds(759, 726, 30, 39);
		panel.add(vary19);
		
		
		JLabel vary21 = new JLabel("0");
		vary21.setFont(new Font("Lucida Grande", Font.PLAIN, 34));
		vary21.setBounds(1027, 489, 30, 39);
		panel.add(vary21);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl.setBounds(787, 547, 36, 40);
		panel.add(lbl);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl1.setBounds(678, 387, 30, 40);
		panel.add(lbl1);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl2.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl2.setBounds(759, 387, 36, 40);
		panel.add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl3.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl3.setBounds(824, 386, 36, 40);
		panel.add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl4.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl4.setBounds(879, 386, 36, 40);
		panel.add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl5.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl5.setBounds(958, 387, 36, 40);
		panel.add(lbl5);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl6.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl6.setBounds(679, 547, 30, 40);
		panel.add(lbl6);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl7.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl7.setBounds(728, 546, 36, 40);
		panel.add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl8.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl8.setBounds(812, 547, 36, 40);
		panel.add(lbl8);
		
		JLabel lbl9;
		lbl9 = new JLabel("");
		lbl9.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl9.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl9.setBounds(730, 658, 22, 26);
		panel.add(lbl9);
		
		JLabel lbl10;
		lbl10 = new JLabel("");
		lbl10.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl10.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl10.setBounds(784, 658, 22, 26);
		panel.add(lbl10);
		
		JLabel lbl11;
		lbl11 = new JLabel("");
		lbl11.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl11.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl11.setBounds(853, 658, 22, 26);
		panel.add(lbl11);
		
		JLabel lbl12;
		lbl12 = new JLabel("");
		lbl12.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl12.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl12.setBounds(885, 658, 24, 26);
		panel.add(lbl12);
		
		JLabel lbl13;
		lbl13 = new JLabel("");
		lbl13.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl13.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl13.setBounds(904, 658, 27, 26);
		panel.add(lbl13);
		
		JLabel lbl14;
		lbl14 = new JLabel("");
		lbl14.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl14.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl14.setBounds(964, 644, 52, 40);
		panel.add(lbl14);
		
		JLabel lbl15;
		lbl15 = new JLabel("");
		lbl15.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl15.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl15.setBounds(948, 694, 30, 40);
		panel.add(lbl15);
		
		JLabel lbl16;
		lbl16 = new JLabel("");
		lbl16.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl16.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl16.setBounds(784, 716, 78, 37);
		panel.add(lbl16);
		
		JLabel lbl17;
		lbl17 = new JLabel("");
		lbl17.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl17.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl17.setBounds(1021, 489, 36, 40);
		panel.add(lbl17);
		
		JLabel lbl18;
		lbl18 = new JLabel("");
		lbl18.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl18.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl18.setBounds(730, 724, 22, 21);
		panel.add(lbl18);
		
		JLabel lbl19;
		lbl19 = new JLabel("");
		lbl19.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl19.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl19.setBounds(870, 663, 22, 21);
		panel.add(lbl19);
		
		JLabel lbl20;
		lbl20 = new JLabel("");
		lbl20.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl20.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl20.setBounds(761, 737, 22, 21);
		panel.add(lbl20);
		
		JLabel lbl21 = new JLabel("");
		lbl21.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl21.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl21.setBounds(840, 644, 36, 40);
		panel.add(lbl21);
		
		JLabel lbl21_1 = new JLabel("");
		lbl21_1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl21_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl21_1.setBounds(662, 329, 36, 40);
		panel.add(lbl21_1);
		
		JLabel lbl21_1_1 = new JLabel("");
		lbl21_1_1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		lbl21_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lbl21_1_1.setBounds(542, 619, 22, 26);
		panel.add(lbl21_1_1);
		
		JLabel lblx = new JLabel("x");
		lblx.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
		lblx.setBounds(636, 547, 30, 39);
		panel.add(lblx);
		
		JLabel user1 = new JLabel("");
		user1.setBounds(163, 229, 321, 28);
		panel.add(user1);
		
		JButton backbtn1 = new JButton("Back");
		backbtn1.setBounds(97, 340, 117, 29);
        backbtn1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        backbtn1.addActionListener(e -> cardLayout.show(contentPane, "Grade7"));
        panel.add(backbtn1);
        
        JButton reloadbtn = new JButton("Reload");
		reloadbtn.setBounds(103, 426, 111, 38);
        reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        reloadbtn.addActionListener(e -> {
            try (BufferedReader r = new BufferedReader(new FileReader("Card.txt"))) {
            	int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			int vard=Integer.parseInt(r.readLine());
    			int vare=Integer.parseInt(r.readLine());
    			int vary=vara*varb;
    			int varya=vara*varb-varc;
                
    			vary1.setText(vara+"");
    			vary2.setText(vary+"");
    			vary3.setText(varc+"");
    			vary4.setText(vard+"");
    			vary5.setText(vare+"");
    			vary1b.setText(vara+"");
    			vary6.setText(vara+"");
    			vary7.setText(varya+"");
    			vary8.setText(vard+"");
    			vary9.setText(vare*-1+"");
    			vary10.setText(vara+"");
    			vary11.setText(vara+"");
    			vary12.setText(vard+"");
    			vary13.setText(vare*-1+"");
    			vary14.setText(-(varya)+"");
    			vary15.setText((vara-vard)*1+"");
    			vary16.setText(-(varya)+vare*-1+"");
    			vary17.setText((vara-vard)*-1+"");
    			vary18.setText(-(vara*varb-varc)+vare*-1+"");
    			vary19.setText(vara-vard+"");
    			vary21.setText(vara+"");
         
                
                // ... continue updating all your other step labels
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        panel.add(reloadbtn);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 8.03.21 PM.png")));
		background.setBounds(0, 0, 1219, 782);
		panel.add(background);
		
		try
		{
			File f1 = new File("Card.txt");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			
			int vara=Integer.parseInt(r.readLine());
			int varb=Integer.parseInt(r.readLine());
			int varc=Integer.parseInt(r.readLine());
			int vard=Integer.parseInt(r.readLine());
			int vare=Integer.parseInt(r.readLine());
			int vary=vara*varb;
			int varya=vara*varb-varc;
			//calculations are made here
			vary1.setText(vara+"");
			vary2.setText(vary+"");
			vary3.setText(varc+"");
			vary4.setText(vard+"");
			vary5.setText(vare+"");
			vary1b.setText(vara+"");
			vary6.setText(vara+"");
			vary7.setText(varya+"");
			vary8.setText(vard+"");
			vary9.setText(vare*-1+"");
			vary10.setText(vara+"");
			vary11.setText(vara+"");
			vary12.setText(vard+"");
			vary13.setText(vare*-1+"");
			vary14.setText(-(varya)+"");
			vary15.setText((vara-vard)*1+"");
			vary16.setText(-(varya)+vare*-1+"");
			vary17.setText((vara-vard)*-1+"");
			vary18.setText(-(vara*varb-varc)+vare*-1+"");
			vary19.setText(vara-vard+"");
			vary21.setText(vara+"");	
			
		
				
			
			
			
			//System.out.println(n);
		
			//System.out.println(n2)

			r.close();
			
		}
		catch (Exception e)
		{
	}
		try
		{
			File f1 = new File("Username.txt");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			
			String user=r.readLine();
			user1.setText(user);
			
			
			

			
			
			
			//System.out.println(n);
		
			//System.out.println(n2)

			r.close();
			
		}
		catch (Exception e)
		{
}
        return panel;
    }
    
 private JPanel createGrade7aPanel() {
    	
	 JPanel panel = new JPanel(null);
    	JButton menubtn = new JButton("<-- Back to Menu");
		menubtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
		
		JLabel problem = new JLabel("");
		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		problem.setBounds(288, 473, 362, 62);
		panel.add(problem);
		
		JLabel lblAddTheFollowing = new JLabel("Add the following fractions");
		lblAddTheFollowing.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblAddTheFollowing.setBounds(278, 388, 456, 105);
		panel.add(lblAddTheFollowing);
		
		JButton nextbtn = new JButton("Next question");
		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade72bPanel"));
		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		nextbtn.setBounds(288, 633, 266, 69);
		panel.add(nextbtn);
		
		JLabel question = new JLabel("");
		question.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		question.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		question.setBounds(278, 388, 456, 105);
		panel.add(question);
		menubtn.setBounds(22, 205, 158, 38);
		panel.add(menubtn);
		
		
		JButton generbtn = new JButton("Generate");
		generbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			int a=0;
			int d=0;
			int u=0;
			int i=0;
			int o=0;
			int c=0;
				
			
				 while(true) {
					
					 a=(int) ((Math.random()*((7-1)+1))+1);
					 d=(int) ((Math.random()*((7-1)+1))+1);
					 u=(int) ((Math.random()*((7-1)+1))+1);
					 i=(int) ((Math.random()*((7-1)+1))+1);	
					 
					 c=(int) ((Math.random()*((10-1)+1))+1);
					 o=(int) ((Math.random()*((10-1)+1))+1);	
						if((d*c)==(i*o))
						{
							break;
						}
					 
					}
				 
			
		
			problem.setText(a+"/"+d+"+"+u+"/"+i);
			int n1=a;
			int n2=d;
			int n3=u;
			int n4=i;
			int n5=c;
			int n6=o;
			
			try{
				File f = new File("Card1.txt"); // Creates the actual file
				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

				w.println(n1);
				w.println(n2);
				w.println(n3);
				w.println(n4);
				w.println(n5);
				w.println(n6);
				

				w.close();
				}

				catch (Exception ee)
				{

				}
			
			}
		
		});
		
		
		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		generbtn.setBounds(722, 596, 203, 79);
		panel.add(generbtn);
		
		JButton stepbtn = new JButton("Show steps");
		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade7aSteps"));
		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		stepbtn.setBounds(714, 275, 222, 54);
		panel.add(stepbtn);
		
		JLabel fraclbl = new JLabel("Fractions");
		fraclbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		fraclbl.setBounds(295, 250, 322, 54);
		panel.add(fraclbl);
		
		JLabel Fraclbl = new JLabel("");
		Fraclbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		Fraclbl.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		Fraclbl.setBounds(283, 250, 322, 54);
		panel.add(Fraclbl);
		
		JLabel user1 = new JLabel("");
		user1.setBounds(95, 135, 321, 28);
		panel.add(user1);
		
		JLabel background = new JLabel("");
		background.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-10-27 at 1.58.16 PM.png")));
		background.setBounds(0, 0, 1165, 778);
		panel.add(background);
		
		try
		{
			File f1 = new File("Username.txt");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			
			String user=r.readLine();
			user1.setText(user);
			
			//System.out.println(n);
		
			//System.out.println(n2)

			r.close();
			
		}
		catch (Exception e)
		{
		}	
		return panel;
		
		
    	
 }
 private JPanel createGrade7aStepsPanel() {
 	
	 JPanel panel = new JPanel(null);
	 JButton backbtn = new JButton("<-- Back");
		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade7a"));
		backbtn.setBounds(114, 343, 117, 29);
		panel.add(backbtn);
		
		JButton nextbtn = new JButton("Next question");
		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade72bPanel"));
        panel.add(nextbtn);
		
		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		nextbtn.setBounds(893, 617, 192, 89);
		panel.add(nextbtn);
		
		JLabel fraclbl = new JLabel("Fractions");
		fraclbl.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
		fraclbl.setBounds(198, 63, 390, 71);
		panel.add(fraclbl);
		
		JLabel answer = new JLabel("0/0+0/0");
		answer.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		answer.setBounds(471, 557, 220, 44);
		panel.add(answer);
		
		JLabel step2 = new JLabel("add the fractions");
		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		step2.setBounds(441, 502, 688, 59);
		panel.add(step2);
		
		JLabel problem1 = new JLabel("");
		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		problem1.setBounds(572, 434, 220, 44);
		panel.add(problem1);
		
		JLabel step1 = new JLabel("so that they have common denominators");
		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		step1.setBounds(427, 386, 603, 36);
		panel.add(step1);
		
		
		
		JLabel step1a = new JLabel("multiply the denominators and numerators");
		step1a.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		step1a.setBounds(431, 343, 688, 59);
		panel.add(step1a);
		
		JLabel cover3 = new JLabel("");
		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		cover3.setBounds(431, 296, 654, 210);
		panel.add(cover3);
		
		JLabel cover2 = new JLabel("");
		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		cover2.setBounds(200, 610, 935, 147);
		panel.add(cover2);
		
		JLabel cover1 = new JLabel("");
		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		cover1.setBounds(431, 427, 654, 210);
		panel.add(cover1);
		
		JLabel cover = new JLabel("New label");
		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
		cover.setBounds(164, 78, 393, 53);
		panel.add(cover);
		
		JLabel user1 = new JLabel("");
		user1.setBounds(131, 231, 321, 28);
		panel.add(user1);
		
		JButton reloadbtn = new JButton("Reload");
		reloadbtn.setBounds(103, 426, 111, 38);
        reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        reloadbtn.addActionListener(e -> {
            try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
            	int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			int vard=Integer.parseInt(r.readLine());
    			
    			int vare=Integer.parseInt(r.readLine());
    			int varf=Integer.parseInt(r.readLine());
    			
    			//calcualtions are made here.
    			problem1.setText(vara*vare+"/"+varb*vare+"+"+varc*varf+"/"+vard*varf);
    			int ans1=vara*vare;
    			int ans2=varb*vare;
    			int ans3= varc*varf;
    			answer.setText(ans1+ans3+"/"+ans2);

                // ... continue updating all your other step labels
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        panel.add(reloadbtn);
        
		JLabel background = new JLabel("");
		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 8.03.21 PM.png")));
		background.setBounds(0, 0, 1219, 782);
		panel.add(background);
		
		 
		
		try
		{
			File f1 = new File("Card1.txt");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			
			int vara=Integer.parseInt(r.readLine());
			int varb=Integer.parseInt(r.readLine());
			int varc=Integer.parseInt(r.readLine());
			int vard=Integer.parseInt(r.readLine());
			
			int vare=Integer.parseInt(r.readLine());
			int varf=Integer.parseInt(r.readLine());
			
			//calcualtions are made here.
			problem1.setText(vara*vare+"/"+varb*vare+"+"+varc*varf+"/"+vard*varf);
			int ans1=vara*vare;
			int ans2=varb*vare;
			int ans3= varc*varf;
			answer.setText(ans1+ans3+"/"+ans2);

			
			
			
			//System.out.println(n);
		
			//System.out.println(n2)

			r.close();
			
		}
		catch (Exception e)
		{
	}
		try
		{
			File f1 = new File("Username.txt");
			FileReader in = new FileReader (f1);
			BufferedReader r = new BufferedReader(in);
			
			
			String user=r.readLine();
			user1.setText(user);
			
			
			

			
			
			
			//System.out.println(n);
		
			//System.out.println(n2)

			r.close();
			
		}
		catch (Exception e)
		{
		}	
	return panel;
	 }
        private JPanel createGrade72bPanel() {
        	JPanel panel=new JPanel(null);
        	JLabel problem = new JLabel("Last week 24,000 fans attended a football match. This week three times as ");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		problem.setBounds(230, 375, 783, 62);
    		problem.setVisible(false);
    		panel.add(problem);
    		
    		JLabel problem2 = new JLabel("many bought tickets, but 1/6 of them canceled their tickets. How many");
    		problem2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		problem2.setBounds(230, 415, 783, 47);
    		problem2.setVisible(false);
    		panel.add(problem2);
    		
    		JLabel problem3 = new JLabel("are attending?");
    		problem3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		problem3.setBounds(230, 446, 290, 47);
    		problem3.setVisible(false);
    		panel.add(problem3);
    		
    		JLabel worprolbl = new JLabel("Word Problems");
    		worprolbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		worprolbl.setBounds(290, 255, 322, 47);
    		panel.add(worprolbl);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(278, 388, 456, 105);
    		panel.add(cover1);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				
    			problem.setVisible(true);
    			problem2.setVisible(true);
    			problem3.setVisible(true);
    				
    				
    			int a=0;
    			int d=0;
    			int u=0;
    			
    			//a = number of fans
    			//d = how many times more
    			//u = how many cancelled.
    					 a=(int) ((Math.random()*((30000-10000)+1))+1);
    					 d=(int) ((Math.random()*((5-1)+1))+1);
    					 u=(int) ((Math.random()*((10-1)+1))+1);	
    						
    					 
    					 problem.setText("Last week "+a+" fans attended a football match. This week "+d+ " times as ");
    					 problem2.setText("many bought tickets, but "+ 1+"/"+u+" of them canceled their tickets. How many");
    					 problem3.setText("are attending?");
    		
    			
    					 int n1=a;
    					 int n2=d;
    					 int n3=u;
    			
    			
    			
    			
    			
    			
    			try{
    				File f = new File("Card2.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				w.println(n3);
    				
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    				JButton backbtn = new JButton("<-- Back to Menu");
    				backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    				backbtn.setBounds(22, 205, 158, 38);
    				panel.add(backbtn);
    		
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(722, 596, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade72bSteps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(714, 275, 222, 54);
    		panel.add(stepbtn);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover.setBounds(290, 248, 322, 54);
    		panel.add(cover);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-10-27 at 1.58.16 PM.png")));
    		background.setBounds(0, 0, 1165, 778);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			

    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
    		
        	return panel;
        }
        private JPanel createGrade72bstepsPanel(){
        	JPanel panel=new JPanel(null);
        	
        	JButton donebtn = new JButton("Done");
        	donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));

    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		donebtn.setBounds(1005, 663, 192, 89);
    		panel.add(donebtn);
    				
    		
    		JButton backbtn = new JButton("<-- Back");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade72bPanel"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JLabel Step1 = new JLabel(" ");
    		Step1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		Step1.setBounds(419, 342, 697, 53);
    		panel.add(Step1);
    		
    		JLabel Step1a = new JLabel("");
    		Step1a.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
    		Step1a.setBounds(448, 427, 512, 29);
    		panel.add(Step1a);
    		
    		JLabel Step2 = new JLabel("");
    		Step2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		Step2.setBounds(434, 499, 697, 53);
    		panel.add(Step2);
    		
    		JLabel Step2a = new JLabel("");
    		Step2a.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		Step2a.setBounds(389, 564, 378, 53);
    		panel.add(Step2a);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(434, 485, 668, 115);
    		panel.add(cover);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(226, 612, 890, 142);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(419, 315, 668, 115);
    		panel.add(cover2);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(116, 231, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card2.txt"))) {
                	double vara=Integer.parseInt(r.readLine());
        			double varb=Integer.parseInt(r.readLine());
        			double varc=Integer.parseInt(r.readLine());
        			
        			//calculations are made here.
        			Step1.setText("multiply the number of fans by how many times as many bought tickets");
        			Step1a.setText(vara+" x "+varb+"="+(vara*varb));
        			Step2.setText("Then divide by "+varc);
        			double ans=(vara*varb)/varc;
        			Step2a.setText((vara*varb)+"/"+varc+"="+ans);
             
                    
                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
    		panel.add(reloadbtn);
    		
    		JLabel background = new JLabel("");
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 8.03.21 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		
    		
    	
    		
    		try
    		{
    			File f1 = new File("Card2.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			double vara=Integer.parseInt(r.readLine());
    			double varb=Integer.parseInt(r.readLine());
    			double varc=Integer.parseInt(r.readLine());
    			
    			//calculations are made here.
    			Step1.setText("multiply the number of fans by how many times as many bought tickets");
    			Step1a.setText(vara+" x "+varb+"="+(vara*varb));
    			Step2.setText("Then divide by "+varc);
    			double ans=(vara*varb)/varc;
    			Step2a.setText((vara*varb)+"/"+varc+"="+ans);
    			
    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			

    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	
        	
        	
        	return panel;
        }
        private JPanel createGrade8Panel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));

    	
    		
    		JLabel problem = new JLabel("");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem.setBounds(524, 459, 54, 62);
    		panel.add(problem);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem1.setBounds(733, 584, 54, 62);
    		panel.add(problem1);
    		
    		JLabel probpic = new JLabel("");
    		probpic.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-17_at_1.41.37_PM-removebg-preview.png")));
    		probpic.setBounds(571, 354, 354, 244);
    		panel.add(probpic);
    		
    		JLabel pic8lbl = new JLabel("");
    		pic8lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-17_at_1.59.32_PM-removebg-preview.png")));
    		pic8lbl.setBounds(969, 47, 91, 76);
    		panel.add(pic8lbl);
    		
    		JLabel question = new JLabel("Find c");
    		question.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		question.setBounds(278, 388, 456, 105);
    		panel.add(question);
    		
    		JButton nextbtn = new JButton("Next question");
       		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8a"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		nextbtn.setBounds(288, 633, 266, 69);
    		panel.add(nextbtn);
    		
    		JLabel cover = new JLabel("");
    		cover.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(278, 388, 456, 105);
    		panel.add(cover);
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				
    			
    				
    				
    			int a=0;
    			int d=0;
    	
    					 a=(int) ((Math.random()*((30-1)+1))+1);
    					 d=(int) ((Math.random()*((30-1)+1))+1);
    					 	
    				
    		
    			problem.setText(a+"");
    			problem1.setText(d+"");
    			
    			int n1=a;
    			int n2=d;
    			
    			
    		
    			
    			
    			try{
    				File f = new File("Card3.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				
    				
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(755, 646, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
       		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8Steps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(714, 275, 222, 54);
    		panel.add(stepbtn);
    		
    		JLabel pythalbl = new JLabel("Pythagorean");
    		pythalbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		pythalbl.setBounds(295, 250, 322, 54);
    		panel.add(pythalbl);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover1.setBounds(283, 250, 322, 54);
    		panel.add(cover1);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.56.17 PM.png")));
    		background.setBounds(0, 0, 1165, 778);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        private JPanel createGrade8stepsPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back");
       		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton nextbtn = new JButton("Next question");
       		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8a"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		nextbtn.setBounds(893, 617, 192, 89);
    		panel.add(nextbtn);
    		
    		JLabel lbl8 = new JLabel("8");
    		lbl8.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl8.setBounds(925, 71, 117, 71);
    		panel.add(lbl8);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(915, 60, 117, 71);
    		panel.add(cover);
    		
    		JLabel answer = new JLabel("");
    		answer.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		answer.setBounds(539, 573, 220, 44);
    		panel.add(answer);
    		
    		
    		
    		
    		JLabel sqrrtlbl = new JLabel("");
    		sqrrtlbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-18 at 3.01.24 PM.png")));
    		sqrrtlbl.setBounds(494, 573, 97, 53);
    		panel.add(sqrrtlbl);
    		
    		JLabel pythalbl = new JLabel("Pythagorean");
    		pythalbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		pythalbl.setBounds(244, 60, 390, 71);
    		panel.add(pythalbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(460, 398, 390, 44);
    		panel.add(problem);
    		
    		JLabel step2 = new JLabel("then square root your answer");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		
    		JLabel step1 = new JLabel("square a and b then add.");
    		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1.setBounds(431, 343, 688, 59);
    		panel.add(step1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			//calculations are made here.
        			int a=vara*vara;
        			int b=varb*varb;
        			problem.setText(a+"+"+b);
        			answer.setText(a+b+"");

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(431, 296, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(200, 610, 935, 147);
    		panel.add(cover4);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(164, 78, 393, 53);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(431, 427, 654, 210);
    		panel.add(cover3);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(104, 233, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 1.13.12 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		
    		
            try
    		{
    			File f1 = new File("Card3.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			//calculations are made here.
    			int a=vara*vara;
    			int b=varb*varb;
    			problem.setText(a+"+"+b);
    			answer.setText(a+b+"");
    		
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        private JPanel createGrade8aPanel( ) {
        	JPanel panel=new JPanel(null);
        	
        	JButton backbtn = new JButton("<-- Back to Menu");
       		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		
    		JLabel question = new JLabel("Find the Circumference using the radius.");
    		question.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		question.setBounds(278, 341, 595, 105);
    		panel.add(question);
    	
    		
    		JLabel problem = new JLabel("");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem.setBounds(746, 438, 54, 62);
    		panel.add(problem);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem1.setBounds(733, 584, 54, 62);
    		panel.add(problem1);
    		
    		JLabel piccirclbl = new JLabel("");
    		piccirclbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-18 at 8.10.47 PM.png")));
    		piccirclbl.setBounds(676, 412, 222, 208);
    		panel.add(piccirclbl);
    		
    		JLabel pic8lbl = new JLabel("");
    		pic8lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-17_at_1.59.32_PM-removebg-preview.png")));
    		pic8lbl.setBounds(969, 47, 91, 76);
    		panel.add(pic8lbl);
    		
    		JButton nextbtn = new JButton("Next question");
    	   	nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8b"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		nextbtn.setBounds(288, 633, 266, 69);
    		panel.add(nextbtn);
    		
    		JLabel cover = new JLabel("");
    		cover.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(278, 388, 456, 105);
    		panel.add(cover);
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    			
    	
    					 int a=(int) ((Math.random()*((20-1)+1))+1);
    					
    	
    			problem.setText(a+"");
    			int n1=a;
    			
    			try{
    				File f = new File("Card4.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(755, 646, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    	   	stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8bSteps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(714, 275, 222, 54);
    		panel.add(stepbtn);
    		
    		JLabel cirlbl = new JLabel("Circumference of a Circle");
    		cirlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		cirlbl.setBounds(295, 250, 449, 54);
    		panel.add(cirlbl);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover1.setBounds(283, 250, 322, 54);
    		panel.add(cover1);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.56.17 PM.png")));
    		background.setBounds(0, 0, 1165, 778);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    		
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
        	}
			return panel;
        }
        private JPanel createGrade8astepsPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8a"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton nextbtn = new JButton("Next question");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8b"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		nextbtn.setBounds(893, 617, 192, 89);
    		panel.add(nextbtn);
    		
    		JLabel lbl8 = new JLabel("8");
    		lbl8.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl8.setBounds(925, 71, 117, 71);
    		panel.add(lbl8);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(915, 60, 117, 71);
    		panel.add(cover);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem1.setBounds(539, 573, 220, 44);
    		panel.add(problem1);
    		
    		JLabel circlelbl = new JLabel("Circumference of a Circle");
    		circlelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
    		circlelbl.setBounds(60, 64, 838, 71);
    		panel.add(circlelbl);
    		
    		JLabel formulbl = new JLabel("0");
    		formulbl.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		formulbl.setBounds(460, 398, 390, 44);
    		panel.add(formulbl);
    		
    		JLabel step2 = new JLabel("then multiply");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		JLabel step1 = new JLabel("plug them into your formula");
    		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1.setBounds(431, 343, 688, 59);
    		panel.add(step1);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(431, 296, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 147);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("New label");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(164, 78, 393, 53);
    		panel.add(cover3);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(431, 427, 654, 210);
    		panel.add(cover4);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(114, 231, 321, 28);
    		panel.add(user1);
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			
        			double Cir=2*vara*3.14;
        			formulbl.setText(2+"x"+vara+"𝝿"+"("+2+""+"𝝿"+"r"+"="+"C"+")");
        			
        			problem1.setText(Cir+"");

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
            
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 1.13.12 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		
    		
    		try
    		{
    			File f1 = new File("Card4.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			
    			double Cir=2*vara*3.14;
    			formulbl.setText(2+"x"+vara+"𝝿"+"("+2+""+"𝝿"+"r"+"="+"C"+")");
    			
    			problem1.setText(Cir+"");
    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			

    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	return panel;
        }
        private JPanel createGrade8bPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		
    		
    	
    		
    		JLabel problem = new JLabel("");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem.setBounds(288, 469, 357, 62);
    		panel.add(problem);
    		
    		JLabel problem1 = new JLabel("Find f(x) when x=(value)");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
    		problem1.setBounds(305, 388, 461, 62);
    		panel.add(problem1);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-17_at_1.59.32_PM-removebg-preview.png")));
    		cover.setBounds(969, 47, 91, 76);
    		panel.add(cover);
    		
    		JButton donebtn = new JButton("Done");
    		donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		donebtn.setBounds(286, 634, 266, 69);
    		panel.add(donebtn);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(278, 388, 456, 105);
    		panel.add(cover1);
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				
    				
    			int a=0;
    			int d=0;
    			int i=0;
    			
    	
    					 a=(int) ((Math.random()*((9-1)+1))+1);
    					 d=(int) ((Math.random()*((9-1)+1))+1);
    					 i=(int) ((Math.random()*((9-1)+1))+1);
    					
    	
    			problem.setText("f(x)"+"="+a+"x"+"+"+d);
    			problem1.setText("Find f(x) when x= "+i);
    			
    			
    			
    			try{
    				File f = new File("Card5.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(a);
    				w.println(d);
    				w.println(i);
    				
    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(755, 646, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8bSteps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(714, 275, 222, 54);
    		panel.add(stepbtn);
    		
    		JLabel funclbl = new JLabel("Functions");
    		funclbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		funclbl.setBounds(295, 250, 322, 54);
    		panel.add(funclbl);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
    		cover2.setBounds(283, 250, 322, 54);
    		panel.add(cover2);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.56.17 PM.png")));
    		background.setBounds(0, 0, 1165, 778);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	return panel;
        }
        private JPanel createGrade8bstepsPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade8b"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton donebtn = new JButton("Done");
    		donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		donebtn.setBounds(893, 617, 192, 89);
    		panel.add(donebtn);
    		
    		JLabel lbl8 = new JLabel("8");
    		lbl8.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl8.setBounds(925, 71, 117, 71);
    		panel.add(lbl8);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(915, 60, 117, 71);
    		panel.add(cover);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem1.setBounds(539, 573, 220, 44);
    		panel.add(problem1);
    		
    		JLabel funclbl = new JLabel("Functions");
    		funclbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		funclbl.setBounds(325, 71, 390, 71);
    		panel.add(funclbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(460, 398, 390, 44);
    		panel.add(problem);
    		
    		JLabel step2 = new JLabel("then solve");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		
    		JLabel step1 = new JLabel("plug them into your function");
    		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1.setBounds(431, 343, 688, 59);
    		panel.add(step1);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(431, 296, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 147);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(164, 78, 393, 53);
    		panel.add(cover3);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(431, 427, 654, 210);
    		panel.add(cover4);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(114, 240, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			int varc=Integer.parseInt(r.readLine());
        			//calculations are made here.
        			problem.setText("f(x)"+"="+vara+"*"+varc+"+"+varb);
        			int ans= vara*varc+varb;
        			problem1.setText(ans+"="+"f(x)");

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 1.13.12 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Card5.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			//calculations are made here.
    			problem.setText("f(x)"+"="+vara+"*"+varc+"+"+varb);
    			int ans= vara*varc+varb;
    			problem1.setText(ans+"="+"f(x)");
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        
        private JPanel createGrade9Panel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		JLabel probstats = new JLabel("");
    		probstats.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstats.setBounds(287, 442, 366, 38);
    		panel.add(probstats);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    		
    			int a=0;
    			int d=0;
    			int u=0;
    			int i=0;
    			int o=0;
    		
    				 a=(int) ((Math.random()*((100-1)+1))+1);
    				 d=(int) ((Math.random()*((100-1)+1))+1);
    				 u=(int) ((Math.random()*((100-1)+1))+1);
    				 i=(int) ((Math.random()*((100-1)+1))+1);
    				 o=(int) ((Math.random()*((100-1)+1))+1);
    
    			probstats.setText(a+";"+d+";"+i+";"+u+";"+o+"");
    			int n1=a;
    			int n2=d;
    			int n3=u;
    			int n4=i;
    			int n5=o;
    		
    	
    			
    			try{
    				File f = new File("Card6.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				w.println(n3);
    				w.println(n4);
    				w.println(n5);
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(768, 499, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9Steps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(768, 275, 203, 79);
    		panel.add(stepbtn);
    		
    		JLabel questionbtn = new JLabel("");
    		questionbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		questionbtn.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		questionbtn.setBounds(303, 453, 349, 40);
    		panel.add(questionbtn);
    		
    		JButton nextbtn = new JButton("Next question");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9a"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		nextbtn.setBounds(287, 625, 262, 79);
    		panel.add(nextbtn);
    		
    		JLabel pic9lbl = new JLabel("");
    		pic9lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-22_at_2.21.54_PM-removebg-preview.png")));
    		pic9lbl.setBounds(975, 49, 99, 89);
    		panel.add(pic9lbl);
    		
    		JLabel probstat = new JLabel("find the mean.");
    		probstat.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstat.setBounds(286, 390, 366, 51);
    		panel.add(probstat);
    		
    		JLabel statlbl = new JLabel("Statistics");
    		statlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		statlbl.setBounds(287, 261, 306, 49);
    		panel.add(statlbl);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(287, 261, 306, 49);
    		panel.add(cover);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(287, 390, 452, 51);
    		panel.add(cover1);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(UIManager.getFont("Button.font"));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.41.19 PM.png")));
    		background.setBounds(0, 6, 1165, 772);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        private JPanel createGrade9stepsPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton nextbtn = new JButton("Next Question");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9a"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		nextbtn.setBounds(893, 617, 192, 89);
    		panel.add(nextbtn);
    		
    		JLabel gradelbl = new JLabel("9");
    		gradelbl.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		gradelbl.setBounds(893, 71, 117, 71);
    		panel.add(gradelbl);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(893, 71, 117, 71);
    		panel.add(cover);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem1.setBounds(539, 573, 220, 44);
    		panel.add(problem1);
    		
    		JLabel statlbl = new JLabel("Statistics");
    		statlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		statlbl.setBounds(325, 71, 390, 71);
    		panel.add(statlbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(460, 398, 625, 44);
    		panel.add(problem);
    		
    		JLabel step2 = new JLabel("divide by how many values you have");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		
    		JLabel step1 = new JLabel("");
    		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1.setBounds(431, 343, 688, 59);
    		panel.add(step1);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(418, 296, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 147);
    		panel.add(cover2);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(154, 78, 403, 53);
    		panel.add(cover4);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(418, 427, 654, 210);
    		panel.add(cover3);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(109, 235, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			int varc=Integer.parseInt(r.readLine());
        			int vard=Integer.parseInt(r.readLine());
        			int vare=Integer.parseInt(r.readLine());
        			
        			// calculations are made here.
        			double ans=vara+varb+varc+vard+vare;
        			problem.setText(vara+"+"+varb+"+"+varc+"+"+vard+"+"+vare+"="+ans);
        			double ans1= ans/5;
        			problem1.setText(ans1+"");

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 2.15.41 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		
    		
    		try
    		{
    			File f1 = new File("Card6.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			int vard=Integer.parseInt(r.readLine());
    			int vare=Integer.parseInt(r.readLine());
    			
    			// calculations are made here.
    			double ans=vara+varb+varc+vard+vare;
    			problem.setText(vara+"+"+varb+"+"+varc+"+"+vard+"+"+vare+"="+ans);
    			double ans1= ans/5;
    			problem1.setText(ans1+"");
    		
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			//username is set here
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			

    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	return panel;
        }
        private JPanel createGrade9aPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		JLabel squared = new JLabel("2");
    		squared.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		squared.setVisible(false);
    		squared.setBounds(319, 434, 29, 25);
    		panel.add(squared);
    		
    		JLabel probstats = new JLabel("");
    		probstats.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstats.setBounds(287, 442, 366, 38);
    		panel.add(probstats);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    			
    				squared.setVisible(true);
    				
    			int a=0;
    			int d=0;
    			int u=0;	 
    			int ratroot=0;
    			
    			 while(ratroot<2)
    			 {
    				 // loop is so that there will always be two x-intercepts
    				 //based on the formula b^2-4*ac.
    			 a=(int) ((Math.random()*((5-1)+1))+1);
    			 d=(int) ((Math.random()*((5-1)+1))+1);
    			 u=(int) ((Math.random()*((5-1)+1))+1);
    			 ratroot=(d*d)-4*a*u;
    			 }
    			 
    			
    			
    			probstats.setText(a+"x"+"+"+d+"x"+"+"+u);
    			int n1=a;
    			int n2=d;
    			int n3=u;
    			
    			try{
    				File f = new File("Card7.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				w.println(n3);
    				
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(768, 499, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9aSteps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(768, 275, 203, 79);
    		panel.add(stepbtn);
    		
    		JLabel questionbtn = new JLabel("");
    		questionbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		questionbtn.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		questionbtn.setBounds(303, 453, 349, 40);
    		panel.add(questionbtn);
    		
    		JButton nextbtn = new JButton("Next question");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9b"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		nextbtn.setBounds(287, 625, 262, 79);
    		panel.add(nextbtn);
    		
    		JLabel pic9lbl = new JLabel("");
    		pic9lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-22_at_2.21.54_PM-removebg-preview.png")));
    		pic9lbl.setBounds(975, 49, 99, 89);
    		panel.add(pic9lbl);
    		
    		
    		
    		JLabel probstat = new JLabel("find the x-intercepts");
    		probstat.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstat.setBounds(286, 390, 366, 51);
    		panel.add(probstat);
    		
    		JLabel quadlbl = new JLabel("quadratics");
    		quadlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		quadlbl.setBounds(287, 261, 306, 49);
    		panel.add(quadlbl);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(287, 261, 306, 49);
    		panel.add(cover);
    		
    		JLabel question1lbl = new JLabel("");
    		question1lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		question1lbl.setBounds(287, 390, 452, 51);
    		panel.add(question1lbl);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(UIManager.getFont("Button.font"));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.41.19 PM.png")));
    		background.setBounds(0, 6, 1165, 772);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	

        	return panel;
        }
        private JPanel createGrade9astepsPanel( ) {
        	JPanel panel=new JPanel(null);

    		JLabel square = new JLabel("2");
    		square.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
    		square.setBounds(569, 390, 48, 25);
    		panel.add(square);
    		
    		JLabel problem3 = new JLabel("");
    		problem3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem3.setBounds(483, 647, 625, 44);
    		panel.add(problem3);
    		
    		JLabel line3_1 = new JLabel("");
    		line3_1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-23 at 8.23.33 PM.png")));
    		line3_1.setBounds(402, 641, 223, 3);
    		panel.add(line3_1);
    		
    		JLabel square1 = new JLabel("");
    		square1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-23_at_8.18.01_PM-removebg-preview.png")));
    		square1.setBounds(483, 585, 85, 59);
    		panel.add(square1);
    		
    		JLabel problem2 = new JLabel("");
    		problem2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem2.setBounds(518, 441, 625, 44);
    		panel.add(problem2);
    		
    		JLabel line3 = new JLabel("");
    		line3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-23 at 8.23.33 PM.png")));
    		line3.setBounds(455, 441, 223, 3);
    		panel.add(line3);
    		
    		JLabel line = new JLabel("");
    		line.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-23 at 8.20.11 PM.png")));
    		line.setBounds(593, 384, 41, 10);
    		panel.add(line);
    		
    		JLabel line1 = new JLabel("");
    		line1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-23 at 8.20.11 PM.png")));
    		line1.setBounds(540, 384, 41, 10);
    		panel.add(line1);
    		
    		JButton backbtn = new JButton("<-- Back");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9aSteps"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton nextbtn = new JButton("Next Question");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9b"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		nextbtn.setBounds(893, 617, 192, 89);
    		panel.add(nextbtn);
    		
    		JLabel line4 = new JLabel("");
    		line4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-23 at 8.20.11 PM.png")));
    		line4.setBounds(569, 384, 41, 10);
    		panel.add(line4);
    		
    		JLabel sqrtlbl = new JLabel("");
    		sqrtlbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-23_at_8.18.01_PM-removebg-preview.png")));
    		sqrtlbl.setBounds(500, 384, 128, 59);
    		panel.add(sqrtlbl);
    		
    		JLabel lbl9 = new JLabel("9");
    		lbl9.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl9.setBounds(925, 71, 117, 71);
    		panel.add(lbl9);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(924, 78, 117, 71);
    		panel.add(cover);
    		
    		JLabel lblx = new JLabel("");
    		lblx.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		lblx.setBounds(354, 573, 294, 89);
    		panel.add(lblx);
    		
    		JLabel quadlbl = new JLabel("quadratics");
    		quadlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		quadlbl.setBounds(325, 71, 390, 71);
    		panel.add(quadlbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(402, 395, 625, 44);
    		panel.add(problem);
    		
    		JLabel step2lbl = new JLabel("solve");
    		step2lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2lbl.setBounds(441, 502, 688, 59);
    		panel.add(step2lbl);
    		
    		JLabel step1lbl = new JLabel("plug them into your quadratic formula.");
    		step1lbl.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1lbl.setBounds(431, 343, 688, 59);
    		panel.add(step1lbl);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(400, 296, 685, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 135);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(134, 78, 423, 53);
    		panel.add(cover3);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(421, 427, 664, 210);
    		panel.add(cover4);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(114, 232, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			int varc=Integer.parseInt(r.readLine());
        			//quadratic formula.
        			problem.setText("x=  "+(varb*-1)+"+-     "+varb+"-"+"4"+"*"+vara+"*"+varc);
        			problem2.setText(2+"*"+vara);
        			lblx.setText("x=      "+(varb*-1)+"+-     "+((varb*varb)-4*vara*varc));
        			problem3.setText(2*vara+"");

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 2.15.41 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Card7.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			//quadratic formula.
    			problem.setText("x=  "+(varb*-1)+"+-     "+varb+"-"+"4"+"*"+vara+"*"+varc);
    			problem2.setText(2+"*"+vara);
    			lblx.setText("x=      "+(varb*-1)+"+-     "+((varb*varb)-4*vara*varc));
    			problem3.setText(2*vara+"");
    		
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	
        	return panel;
        }
        private JPanel createGrade9bPanel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		JLabel square = new JLabel("2");
    		square.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		square.setVisible(false);
    		square.setBounds(319, 434, 29, 25);
    		panel.add(square);
    		
    		JLabel probstats = new JLabel("");
    		probstats.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstats.setBounds(287, 442, 366, 38);
    		panel.add(probstats);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    			
    				square.setVisible(true);
    				
    			int a=0;
    			int d=0;
    			int u=0;	 
    			
    			
    			
    			 a=(int) ((Math.random()*((10-1)+1))+1);
    			 d=(int) ((Math.random()*((10-1)+1))+1);
    			 u=(int) ((Math.random()*((10-1)+1))+1);
    			 
    		
    			
    			probstats.setText(a+"x"+"+"+d+"x"+"+"+u);
    			int n1=a;
    			int n2=d;
    			int n3=u;
    		
    			try{
    				File f = new File("Card8.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				w.println(n3);
    				
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(768, 499, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9bSteps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(768, 275, 203, 79);
    		panel.add(stepbtn);
    		
    		JLabel questionbtn = new JLabel("");
    		questionbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		questionbtn.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		questionbtn.setBounds(303, 453, 349, 40);
    		panel.add(questionbtn);
    		
    		JButton donebtn = new JButton("Done");
    		donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		donebtn.setBounds(287, 625, 262, 79);
    		panel.add(donebtn);
    		
    		JLabel pic9lbl = new JLabel("");
    		pic9lbl.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot_2023-11-22_at_2.21.54_PM-removebg-preview.png")));
    		pic9lbl.setBounds(975, 49, 99, 89);
    		panel.add(pic9lbl);
    		
    		
    		
    		JLabel probstat = new JLabel("find how many roots there are.");
    		probstat.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstat.setBounds(286, 390, 459, 51);
    		panel.add(probstat);
    		
    		JLabel quadlbl = new JLabel("quadratics");
    		quadlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		quadlbl.setBounds(287, 261, 306, 49);
    		panel.add(quadlbl);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(287, 261, 306, 49);
    		panel.add(cover);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(287, 390, 452, 51);
    		panel.add(cover1);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(UIManager.getFont("Button.font"));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.41.19 PM.png")));
    		background.setBounds(0, 6, 1165, 772);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        private JPanel createGrade9bstepsPanel( ) {
        	JPanel panel=new JPanel(null);
        	JLabel square = new JLabel("2");
    		square.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		square.setBounds(496, 394, 29, 25);
    		panel.add(square);
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem1.setBounds(229, 573, 614, 59);
    		panel.add(problem1);
    		
    		JButton backbtn = new JButton("<-- Back");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade9b"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton donebtn = new JButton("Done");
    		donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		donebtn.setBounds(893, 617, 192, 89);
    		panel.add(donebtn);
    		
    		JLabel lbl9 = new JLabel("9");
    		lbl9.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl9.setBounds(893, 71, 117, 71);
    		panel.add(lbl9);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(893, 71, 117, 71);
    		panel.add(cover);
    		
    		JLabel quadlbl = new JLabel("quadratics");
    		quadlbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		quadlbl.setBounds(325, 71, 390, 71);
    		panel.add(quadlbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(483, 405, 625, 44);
    		panel.add(problem);
    		
    		JLabel step2 = new JLabel("solve");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		
    		JLabel step1 = new JLabel("plug them into your formula.");
    		step1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step1.setBounds(431, 343, 688, 59);
    		panel.add(step1);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(407, 291, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 147);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(150, 78, 407, 53);
    		panel.add(cover3);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(417, 422, 654, 210);
    		panel.add(cover4);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(114, 234, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			int varc=Integer.parseInt(r.readLine());
        			
        			problem.setText(varb+"-"+4+"*"+vara+"*"+varc);
        			//b^(2)-4ac
        			int ans=((varb*varb)-4*vara*varc);
        			if(ans<0)
        			{
        				problem1.setText((varb*varb)-4*vara*varc+"<0. No rational roots");
        			}
        			if(ans==0)
        			{
        				problem1.setText((varb*varb)-4*vara*varc+"=0. one rational root");
        			}
        			if(ans>0)
        			{
        				problem1.setText((varb*varb)-4*vara*varc+">0. two rational roots");
        			}

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-05 at 2.15.41 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		
    		
    		try
    		{
    			File f1 = new File("Card7.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			
    			problem.setText(varb+"-"+4+"*"+vara+"*"+varc);
    			//b^(2)-4ac
    			int ans=((varb*varb)-4*vara*varc);
    			if(ans<0)
    			{
    				problem1.setText((varb*varb)-4*vara*varc+"<0. No rational roots");
    			}
    			if(ans==0)
    			{
    				problem1.setText((varb*varb)-4*vara*varc+"=0. one rational root");
    			}
    			if(ans>0)
    			{
    				problem1.setText((varb*varb)-4*vara*varc+">0. two rational roots");
    			}
    			
    			
    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	return panel;
        }

        
        private JPanel createGrade10Panel( ) {
        	JPanel panel=new JPanel(null);
        	JButton backbtn = new JButton("<-- Back to Menu");
        	backbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		backbtn.setBounds(22, 205, 158, 38);
    		panel.add(backbtn);
    		
    		JLabel square1 = new JLabel("3");
    		square1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		square1.setVisible(false);
    		square1.setBounds(324, 431, 29, 25);
    		panel.add(square1);
    		
    		JLabel square = new JLabel("2");
    		square.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
    		square.setVisible(false);
    		square.setBounds(399, 431, 29, 25);
    		panel.add(square);
    		
    		JLabel probstats = new JLabel("");
    		probstats.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstats.setBounds(287, 442, 366, 38);
    		panel.add(probstats);
    		
    		
    		JButton generbtn = new JButton("Generate");
    		generbtn.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    			
    				//written first in intercept form
    				//y=(x-p)(x-k)(x-l)
    				 int p=(int) ((Math.random()*((8-1)+1))+1);
    				 int k=(int) ((Math.random()*((8-1)+1))+1);
    				 int l=(int) ((Math.random()*((8-1)+1))+1);
    			//turning it into general form
    			//x^(3)+dx^(2)+ux+i.
    			int d=-l-k-p;
    			int u=(k*l)+(p*l)+(p*k);	 
    			int i=-(p*k*l);
    			
    			
    			square.setVisible(true);
    			square1.setVisible(true);
    			
    			
    			probstats.setText(1+"x"+"+"+d+"x"+"+"+u+"x"+"+"+i);
    			int n1=1;
    			int n2=d;
    			int n3=u;
    			int n4=i;
    			int n5=p;
    			try{
    				File f = new File("Card9.txt"); // Creates the actual file
    				FileOutputStream in = new FileOutputStream(f); // Prepares the file for writing
    				PrintWriter w = new PrintWriter(in); // Allows the user to write on the file

    				w.println(n1);
    				w.println(n2);
    				w.println(n3);
    				w.println(n4);
    				w.println(n5);
    				

    				w.close();
    				}

    				catch (Exception ee)
    				{

    				}
    			
    			}
    		
    		});
    		
    		generbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		generbtn.setBounds(768, 499, 203, 79);
    		panel.add(generbtn);
    		
    		JButton stepbtn = new JButton("Show steps");
    		stepbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade10Steps"));
    		stepbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		stepbtn.setBounds(768, 275, 203, 79);
    		panel.add(stepbtn);
    		
    		JLabel cover = new JLabel("");
    		cover.setFont(new Font("Lucida Grande", Font.PLAIN, 47));
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(303, 453, 349, 40);
    		panel.add(cover);
    		
    		JButton nextbtn = new JButton("Done");
    		nextbtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		nextbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		nextbtn.setBounds(287, 625, 262, 79);
    		panel.add(nextbtn);
    		
    		
    		
    		JLabel probstat = new JLabel("Find one of the rational zeros");
    		probstat.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		probstat.setBounds(286, 390, 459, 51);
    		panel.add(probstat);
    		
    		JLabel plylbl = new JLabel("Polynominals");
    		plylbl.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
    		plylbl.setBounds(287, 261, 306, 49);
    		panel.add(plylbl);
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(287, 261, 306, 49);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(287, 390, 452, 51);
    		panel.add(cover2);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(95, 135, 321, 28);
    		panel.add(user1);
    		
    		JLabel background = new JLabel("");
    		background.setFont(UIManager.getFont("Button.font"));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-12-01 at 1.49.52 PM.png")));
    		background.setBounds(0, 6, 1165, 772);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}	
        	return panel;
        }
        private JPanel createGrade10stepsPanel() {
        	JPanel panel=new JPanel(null);
        	JLabel problem2 = new JLabel("0*0+0");
    		problem2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem2.setBounds(265, 610, 614, 53);
    		panel.add(problem2);
    		
    		JLabel problem3 = new JLabel("0*0+0");
    		problem3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem3.setBounds(265, 656, 614, 53);
    		panel.add(problem3);

 
    		
    		JLabel problem1 = new JLabel("");
    		problem1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem1.setBounds(265, 554, 614, 53);
    		panel.add(problem1);
    		
    		JButton backbtn = new JButton("<-- Back");
    		backbtn.addActionListener(e -> cardLayout.show(contentPane, "Grade10"));
    		backbtn.setBounds(114, 343, 117, 29);
    		panel.add(backbtn);
    		
    		JButton donebtn = new JButton("Done");
    		donebtn.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
    		donebtn.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
    		donebtn.setBounds(893, 617, 192, 89);
    		panel.add(donebtn);
    		
    		JLabel lbl10 = new JLabel("10");
    		lbl10.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
    		lbl10.setBounds(925, 71, 117, 71);
    		panel.add(lbl10);
    		
    		JLabel cover = new JLabel("");
    		cover.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover.setBounds(915, 60, 117, 71);
    		panel.add(cover);
    		
    		JLabel polylbl = new JLabel("Polynominals");
    		polylbl.setFont(new Font("Lucida Grande", Font.PLAIN, 49));
    		polylbl.setBounds(236, 75, 390, 71);
    		panel.add(polylbl);
    		
    		JLabel problem = new JLabel("0");
    		problem.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
    		problem.setBounds(428, 394, 336, 44);
    		panel.add(problem);
    		
    		JLabel step2 = new JLabel("check. (if wrong do step 1 to 2)");
    		step2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		step2.setBounds(441, 502, 688, 59);
    		panel.add(step2);
    		
    		
    		
    		JLabel question = new JLabel("");
    		question.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
    		question.setBounds(431, 343, 688, 59);
    		panel.add(question);
    		
    		
    		JLabel cover1 = new JLabel("");
    		cover1.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover1.setBounds(431, 296, 654, 210);
    		panel.add(cover1);
    		
    		JLabel cover2 = new JLabel("");
    		cover2.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover2.setBounds(200, 610, 935, 147);
    		panel.add(cover2);
    		
    		JLabel cover3 = new JLabel("");
    		cover3.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover3.setBounds(164, 78, 393, 53);
    		panel.add(cover3);
    		
    		JLabel cover4 = new JLabel("");
    		cover4.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 7.07.07 PM.png")));
    		cover4.setBounds(431, 427, 654, 210);
    		panel.add(cover4);
    		
    		JLabel user1 = new JLabel("");
    		user1.setBounds(114, 242, 321, 28);
    		panel.add(user1);
    		
    		JButton reloadbtn = new JButton("Reload");
    		reloadbtn.setBounds(103, 426, 111, 38);
            reloadbtn.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            reloadbtn.addActionListener(e -> {
                try (BufferedReader r = new BufferedReader(new FileReader("Card1.txt"))) {
                	int vara=Integer.parseInt(r.readLine());
        			int varb=Integer.parseInt(r.readLine());
        			int varc=Integer.parseInt(r.readLine());
        			int vard=Integer.parseInt(r.readLine());
        			int vare=Integer.parseInt(r.readLine());
        			//calculations are made here below
        			int ans=vara*vare+varb;
        			int ans1=ans*vare+varc;
        			int ans2=ans1*vare+vard;
        			question.setText("guess the zero. try using multiplies of "+vard);
        			problem.setText(vare+"");
        			problem1.setText(vara+"*"+vare+"+"+varb);
        			problem2.setText(ans+"*"+vare+"+"+varc);
        			problem3.setText(ans1+"*"+vare+"+"+vard+"="+ans2);

                    // ... continue updating all your other step labels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            panel.add(reloadbtn);
    		
    		JLabel background = new JLabel("");
    		background.setFont(new Font("Lucida Grande", Font.PLAIN, 80));
    		background.setIcon(new ImageIcon(MainFrame.class.getResource("/assets/Screenshot 2023-11-04 at 8.03.21 PM.png")));
    		background.setBounds(0, 0, 1219, 782);
    		panel.add(background);
    		
    		try
    		{
    			File f1 = new File("Card9.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			int vara=Integer.parseInt(r.readLine());
    			int varb=Integer.parseInt(r.readLine());
    			int varc=Integer.parseInt(r.readLine());
    			int vard=Integer.parseInt(r.readLine());
    			int vare=Integer.parseInt(r.readLine());
    			//calculations are made here below
    			int ans=vara*vare+varb;
    			int ans1=ans*vare+varc;
    			int ans2=ans1*vare+vard;
    			question.setText("guess the zero. try using multiplies of "+vard);
    			problem.setText(vare+"");
    			problem1.setText(vara+"*"+vare+"+"+varb);
    			problem2.setText(ans+"*"+vare+"+"+varc);
    			problem3.setText(ans1+"*"+vare+"+"+vard+"="+ans2);
    			
    			
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    	}
    		try
    		{
    			File f1 = new File("Username.txt");
    			FileReader in = new FileReader (f1);
    			BufferedReader r = new BufferedReader(in);
    			
    			
    			String user=r.readLine();
    			user1.setText(user);
    			
    			//System.out.println(n);
    		
    			//System.out.println(n2)

    			r.close();
    			
    		}
    		catch (Exception e)
    		{
    		}
        	return panel;
        }
    /** Simple placeholder panel generator */
    private JPanel createPlaceholderPanel(String title, String bgPath) {
        JPanel panel = new JPanel(null);

        JLabel bg = safeIconLabel(bgPath, -13, -6, 1198, 789);
        if (bg != null) panel.add(bg);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setBounds(200, 150, 800, 60);
        panel.add(label);

        JButton back = new JButton("Back");
        back.setBounds(20, 20, 100, 40);
        back.addActionListener(e -> cardLayout.show(contentPane, "Menu"));
        panel.add(back);

        return panel;
    }

    // ===== helpers =====
    private void selectGrade(int grade) {
        selectedGrade = grade;
        if (arro7 != null) arro7.setVisible(false);
        if (arro8 != null) arro8.setVisible(false);
        if (arro9 != null) arro9.setVisible(false);
        if (arro10 != null) arro10.setVisible(false);

        switch (grade) {
            case 7 -> { if (arro7 != null) arro7.setVisible(true); }
            case 8 -> { if (arro8 != null) arro8.setVisible(true); }
            case 9 -> { if (arro9 != null) arro9.setVisible(true); }
            case 10 -> { if (arro10 != null) arro10.setVisible(true); }
        }
    }

    private void goToSubject(String subject) {
        if (selectedGrade == 0) {
            JOptionPane.showMessageDialog(this, "Please select a grade first!");
            return;
        }

        if ("Math".equals(subject)) {
            switch (selectedGrade) {
                case 7 -> cardLayout.show(contentPane, "Grade7");
                case 8 -> cardLayout.show(contentPane, "Grade8");
                case 9 -> cardLayout.show(contentPane, "Grade9");
                case 10 -> cardLayout.show(contentPane, "Grade10");
            }
            return;
        }

        if ("English".equals(subject)) {
            // For now we have Grade7 English placeholder only
            if (selectedGrade == 7) {
                cardLayout.show(contentPane, "Grade7_English");
            } else {
                JOptionPane.showMessageDialog(this, "English panel for Grade " + selectedGrade + " not implemented yet.");
            }
            return;
        }
    }

    /** Safely create ImageIcon (returns a non-null icon even if resource missing) */
    private ImageIcon safeIcon(String resourcePath) {
        try {
            java.net.URL res = MainFrame.class.getResource(resourcePath);
            return (res != null) ? new ImageIcon(res) : new ImageIcon();
        } catch (Exception e) {
            return new ImageIcon();
        }
    }

    /** Safely create JLabel with icon + bounds (returns null if resource missing) */
    private JLabel safeIconLabel(String resourcePath, int x, int y, int w, int h) {
        try {
            java.net.URL res = MainFrame.class.getResource(resourcePath);
            if (res == null) return null;
            JLabel l = new JLabel(new ImageIcon(res));
            l.setBounds(x, y, w, h);
            return l;
        } catch (Exception e) {
            return null;
        }
    }
}
