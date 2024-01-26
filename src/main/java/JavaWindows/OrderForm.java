package JavaWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class OrderForm extends JFrame {
	
    private JLabel label_type, label_parameters, image1, image2, image3, image4, label_windows_height, label_windows_width, label_options, label_windows_package, label_windowsill_width, label_low_tide_width;
    private String[] typeTitles, windows_packageTitles, windowsill_widthTitles, low_tide_widthTitles;
    private ImageIcon image_window;
    private JComboBox<String> typeList, windows_packageList, windowsill_widthList, low_tide_widthList;
    private SpinnerNumberModel windows_heightModel, windows_widthModel1, windows_widthModel2, windows_widthModel3, windows_widthModel4;
    private JSpinner windows_height, windows_width1, windows_width2, windows_width3, windows_width4;

    
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
        Image img = Toolkit.getDefaultToolkit().getImage("logo.png");
        super.setIconImage (img);
        Container container = super.getContentPane();
        container.setLayout(null);


        label_type = new JLabel("Тип окон:");
        typeTitles = new String[] {"Не выбрано", "Односекционное", "Двухсекционные", "Трехсекционные", "Четырехсекционные"};
        typeList = new JComboBox<>(typeTitles);

        label_parameters = new JLabel("Задайте параметры: ");

        image_window = new ImageIcon("window.png");
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
    }
}