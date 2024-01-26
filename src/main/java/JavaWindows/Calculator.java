package JavaWindows;

abstract class Calculator {
    abstract int calculatePrice(Integer height, Integer width, String result_type, String result_windows_package, String result_low_tide_width, String result_windowsill_width);
}

class WindowCalculator extends Calculator  {
    int calculatePrice(Integer height, Integer width, String result_type, String result_windows_package, String result_low_tide_width, String result_windowsill_width) {

        int result_type_int = getResultTypeInt(result_type);
        Pair LongPrice = getHeightAndWidthPrice(result_windows_package);
        int result_windowsill_price = getWindowsillPrice(result_windowsill_width);
        int result_low_tide_width_price = getLowTideWidthPrice(result_low_tide_width);

        return ((height * LongPrice.first + width * LongPrice.second)* result_type_int) + result_windowsill_price + result_low_tide_width_price;
    }

    public int getResultTypeInt(String result_type) {
        int result_type_int = 0;
        if (result_type =="Односекционное") {result_type_int = 1;}
        if (result_type =="Двухсекционные") {result_type_int = 2;}
        if (result_type == "Трехсекционные") {result_type_int = 3;}
        if (result_type == "Четырехсекционные") {result_type_int = 4;}
        return result_type_int;
    }

    public Pair getHeightAndWidthPrice (String result_windows_package) {

        int height_price = 0;
        int width_price = 0;
        if (result_windows_package == "Эконом") {height_price = 1; width_price = 2;}
        if (result_windows_package ==  "Стандарт") {height_price = 2; width_price = 2;}
        if (result_windows_package ==  "Стандарт+") {height_price = 2; width_price = 3;}
        if (result_windows_package ==  "Премиум") {height_price = 3; width_price = 3;}
        return new Pair(height_price, width_price);
    }


    public int getWindowsillPrice(String result_windowsill_width) {
        int result_windowsill_price = 0;
        if (result_windowsill_width == "250 мм") {result_windowsill_price = 400;}
        if (result_windowsill_width == "300 мм") {result_windowsill_price = 472;}
        if (result_windowsill_width == "400 мм") {result_windowsill_price = 616;}
        return result_windowsill_price;
    }


    public int getLowTideWidthPrice(String result_low_tide_width) {
        int result_low_tide_width_price = 0;
        if (result_low_tide_width == "120 мм") {result_low_tide_width_price = 116;}
        if (result_low_tide_width == "150 мм") {result_low_tide_width_price = 135;}
        if (result_low_tide_width =="180 мм") {result_low_tide_width_price = 154;}

        return result_low_tide_width_price;
    }
}

