package JavaWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;



public class OrderForm extends JFrame {
	
    private JLabel label_type, label_parameters, image1, image2, image3, image4, label_windows_height, label_windows_width, label_options, label_windows_package, label_windowsill_width, label_low_tide_width;
    private String[] typeTitles, windows_packageTitles, windowsill_widthTitles, low_tide_widthTitles;
    private ImageIcon image_window;
    private JComboBox<String> typeList, windows_packageList, windowsill_widthList, low_tide_widthList;
    private SpinnerNumberModel windows_heightModel, windows_widthModel1, windows_widthModel2, windows_widthModel3, windows_widthModel4;
    private JSpinner windows_height, windows_width1, windows_width2, windows_width3, windows_width4;
    private JButton send_button, export_button;

    
    public String getTypeList(JComboBox<String>typeList) {
    	return (String) typeList.getSelectedItem().toString();
    }
    public String getWindowsPackageList(JComboBox<String> windows_packageList) {
        return (String) windows_packageList.getSelectedItem().toString();
    }
    public String getWindowsillWidthList(JComboBox<String> windowsill_widthList) {
        return (String) windowsill_widthList.getSelectedItem().toString();
    }
    public String getLowTideWidthList(JComboBox<String> low_tide_widthList ) {
        return (String) low_tide_widthList.getSelectedItem().toString();
    }
    
    public Integer getWindowsWidth(JSpinner windows_width) {return (Integer) windows_width.getValue();}
    public Integer getWindowsHeight(JSpinner windows_height) {return (Integer) windows_height.getValue();}
    

    public OrderForm() {
        super("Калькулятор стоимости оконных конструкций");
        super.setBounds(650, 250, 600, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("logo.png"));
        super.setIconImage (img);
        Container container = super.getContentPane();
        container.setLayout(null);


        label_type = new JLabel("Тип окон:");
        typeTitles = new String[] {"Не выбрано", "Односекционное", "Двухсекционные", "Трехсекционные", "Четырехсекционные"};
        typeList = new JComboBox<>(typeTitles);

        label_parameters = new JLabel("Задайте параметры: ");

        image_window = new ImageIcon(getClass().getClassLoader().getResource("window.png"));
        image1 = new JLabel(image_window);
        image2 = new JLabel(image_window);
        image3 = new JLabel(image_window);
        image4 = new JLabel(image_window);

        label_windows_height = new JLabel("Высота (мм): ");

        windows_heightModel = new SpinnerNumberModel(1500, 430, 2100, 10);
        windows_height = new JSpinner(windows_heightModel);

        windows_widthModel1 = new SpinnerNumberModel(800, 340, 800, 10);
        windows_width1 = new JSpinner(windows_widthModel1);
        windows_widthModel2 = new SpinnerNumberModel(1600, 680, 1600, 10);
        windows_width2 = new JSpinner(windows_widthModel2);
        windows_widthModel3 = new SpinnerNumberModel(2400, 1020, 2400, 10);
        windows_width3 = new JSpinner(windows_widthModel3);
        windows_widthModel4 = new SpinnerNumberModel(3200, 1360, 3200, 10);
        windows_width4 = new JSpinner(windows_widthModel4);

        label_windows_width = new JLabel("Длина (мм): ");

        label_options = new JLabel("Дополнительные опции: ");

        label_windows_package = new JLabel("Стеклопакет: ");
        windows_packageTitles = new String[] {"Эконом", "Стандарт", "Стандарт+", "Премиум"};
        windows_packageList = new JComboBox<>(windows_packageTitles);

        label_windowsill_width = new JLabel("Ширина подоконника: ");
        windowsill_widthTitles = new String[] {"Нет", "250 мм", "300 мм", "400 мм"};
        windowsill_widthList = new JComboBox<>(windowsill_widthTitles);

        label_low_tide_width = new JLabel("Ширина отлива: ");
        low_tide_widthTitles = new String[] {"Нет", "120 мм", "150 мм", "180 мм"};
        low_tide_widthList = new JComboBox<>(low_tide_widthTitles);

        export_button = new JButton("Экспортировать");
        send_button = new JButton("Посчитать");

        container.add(label_type).setBounds(20, 20, 80, 30);
        container.add(typeList).setBounds(90, 20, 150, 30);

        label_parameters.setBounds(20, 70, 150, 30);

        image1.setBounds(20,110,105,140);
        image2.setBounds(125,110,105,140);
        image3.setBounds(230,110,105,140);
        image4.setBounds(335,110,105,140);

        label_windows_height.setBounds(460,145,105,30);
        windows_height.setBounds(460,180,100,30);
        label_windows_width.setBounds(145,270,100,30);
        windows_width1.setBounds(235,270,100,30);
        windows_width2.setBounds(235,270,100,30);
        windows_width3.setBounds(235,270,100,30);
        windows_width4.setBounds(235,270,100,30);

        label_options.setBounds(20,330,200,30);

        label_windows_package.setBounds(40,370,100,30);
        windows_packageList.setBounds(130,370,100,30);

        label_windowsill_width.setBounds(40,410,150,30);
        windowsill_widthList.setBounds(180,410,100,30);

        label_low_tide_width.setBounds(40,450,100,30);
        low_tide_widthList.setBounds(150,450,100,30);

        export_button.setBounds(300,510,150,30);
        send_button.setBounds(470,510,100,30);

        class ItemChangeListener implements ItemListener {

            public void removeElements() {
                container.remove(label_parameters);

                container.remove(image1);
                container.remove(image2);
                container.remove(image3);
                container.remove(image4);
                container.remove(label_windows_height);
                container.remove(windows_height);
                container.remove(label_windows_width);
                container.remove(windows_width1);
                container.remove(windows_width2);
                container.remove(windows_width3);
                container.remove(windows_width4);

                container.remove(label_options);

                container.remove(label_windows_package);
                container.remove(windows_packageList);

                container.remove(label_windowsill_width);
                container.remove(windowsill_widthList);

                container.remove(label_low_tide_width);
                container.remove(low_tide_widthList);

                container.remove(export_button);
                container.remove(send_button);

                container.revalidate();
                container.repaint();
            }

            public void addElements(int num) {
                container.add(label_parameters);

                if (num == 1) {container.add(image3);container.remove(image2);container.remove(image1);container.remove(image1);}
                if (num == 2) {container.add(image2); container.add(image3);container.remove(image1);container.remove(image4);}
                if (num == 3) {container.add(image2); container.add(image3); container.add(image4);container.remove(image1);}
                if (num == 4) {container.add(image1); container.add(image2); container.add(image3); container.add(image4);}
                
                container.add(label_windows_height);
                container.add(windows_height);
                container.add(label_windows_width);

                if (num == 1) {
                    container.remove(windows_width1);
                    container.remove(windows_width2);
                    container.remove(windows_width3);
                    container.remove(windows_width4);
                    container.add(windows_width1);
                }
                if (num == 2) {
                    container.remove(windows_width1);
                    container.remove(windows_width2);
                    container.remove(windows_width3);
                    container.remove(windows_width4);
                    container.add(windows_width2);
                }
                if (num == 3) {
                    container.remove(windows_width1);
                    container.remove(windows_width2);
                    container.remove(windows_width3);
                    container.remove(windows_width4);
                    container.add(windows_width3);
                }
                if (num == 4) {
                    container.remove(windows_width1);
                    container.remove(windows_width2);
                    container.remove(windows_width3);
                    container.remove(windows_width4);
                    container.add(windows_width4);
                }

                container.add(label_options);

                container.add(label_windows_package);
                container.add(windows_packageList);

                container.add(label_windowsill_width);
                container.add(windowsill_widthList);

                container.add(label_low_tide_width);
                container.add(low_tide_widthList);

                container.add (export_button);
                container.add (send_button);

                container.revalidate();
                container.repaint();
            }

                @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        Object item = event.getItem();

                        if (item == typeTitles[0]) {removeElements();}
                        if (item == typeTitles[1]) {addElements(1);}
                        if (item == typeTitles[2]) {addElements(2);}
                        if (item == typeTitles[3]) {addElements(3);}
                        if (item == typeTitles[4]) {addElements(4);}
                    }
                }

            }
            
        typeList.addItemListener(new ItemChangeListener());

        export_button.addActionListener(AListener1);

        send_button.addActionListener(new ButtonEventManager());

    }

    ActionListener AListener1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderForm orderForm = new OrderForm();
            WindowCalculator windowCalculator = new WindowCalculator();
            String result_type = orderForm.getTypeList(typeList);
            int width = 0;
            if (result_type == "Односекционное") {width = (Integer) windows_width1.getValue();}
            if (result_type == "Двухсекционные") {width = (Integer) windows_width2.getValue();}
            if (result_type == "Трехсекционные") {width = (Integer) windows_width3.getValue();}
            if (result_type == "Четырехсекционные") {width = (Integer) windows_width4.getValue();}
            String result_windows_package = orderForm.getWindowsPackageList(windows_packageList);
            String result_low_tide_width = orderForm.getLowTideWidthList(low_tide_widthList);
            String result_windowsill_width = orderForm.getLowTideWidthList(windowsill_widthList);
            int height = orderForm.getWindowsHeight(windows_height);
            int price = windowCalculator.calculatePrice(height,width,result_type, result_windows_package,result_low_tide_width, result_windowsill_width);

            ZonedDateTime now = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy в HH:mm:ss");

            String content = "Экспорт от: " + now.format(formatter) +
                    "\n\nТип окна: " + result_type +
                    "\nВысота (мм): " + height +
                    "\nДлина (мм): " + width +
                    "\nСтеклопакет: " + result_windows_package +
                    "\nШирина подоконника: " + result_windowsill_width +
                    "\nШирина отлива: " + result_low_tide_width +
                    "\n\nЦена: "+ price  +" руб.";
            File file = new File("LastExport.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file.getAbsoluteFile());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            BufferedWriter bw = new BufferedWriter(fw);
            try {
                bw.write(content);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                bw.close(); // Be sure to close BufferedWriter
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };
    
    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	OrderForm orderForm = new OrderForm();
        	WindowCalculator windowCalculator = new WindowCalculator();
        	String result_type = orderForm.getTypeList(typeList);
            int width = 0;
            if (result_type == "Односекционное") {width = (Integer) windows_width1.getValue();}
            if (result_type == "Двухсекционные") {width = (Integer) windows_width2.getValue();}
            if (result_type == "Трехсекционные") {width = (Integer) windows_width3.getValue();}
            if (result_type == "Четырехсекционные") {width = (Integer) windows_width4.getValue();}
        	String result_windows_package = orderForm.getWindowsPackageList(windows_packageList);
        	String result_low_tide_width = orderForm.getLowTideWidthList(low_tide_widthList);
        	String result_windowsill_width = orderForm.getLowTideWidthList(windowsill_widthList);
        	int height = orderForm.getWindowsHeight(windows_height);
        	int price = windowCalculator.calculatePrice(height,width,result_type, result_windows_package,result_low_tide_width, result_windowsill_width);
            JOptionPane.showMessageDialog(null,
                    "Тип окна: " + result_type +
                            "\nВысота (мм): " + height +
                            "\nДлина (мм): " + width +
                            "\nСтеклопакет: " + result_windows_package +
                            "\nШирина подоконника: " + result_windowsill_width +
                            "\nШирина отлива: " + result_low_tide_width +
                            "\n\nЦена: "+ price  +" руб.",
                            "Расчет стоисмости",
                            JOptionPane.PLAIN_MESSAGE);
        }
        
    }

}