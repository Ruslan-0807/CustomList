import  java.util.Arrays;

public   class CustomList {
    private int[] list;

    // Создать конструктор, получает в качестве аргумента массив из целых чисел и присваевает его в массив list
//   Этот конструктор принимает массив целых чисел и инициализирует поле list этим массивом.
    public CustomList(int[] array) {
        this.list = array;
    }

    //создание пустого массива: ничего не получает и присваевает пустой массив в лист
    // Этот конструктор создает пустой список, инициализируя поле list массивом нулевой длинны.
    public CustomList() {
        this.list = new int[0];
    }

    // Переопределить (переписать)  метод toString  класса Object
    // Метод должен возвоащать массив преобразовывает его в строку с использованием Array.toString
    @Override
    public String toString() {
        return Arrays.toString(this.list);
    }

    // добавляем метод IndexOf, который получает целое число и возвращает индекс первого вхождения данного числа
    // в массив . Если вхождений нет, то вернуть -1
    public int IndexOf(int number) {
        for (int i = 0; i < this.list.length; i++) {
            if (list[i] == number) {
                return i;
            }
        }
        return -1;
    }
    // Добавить метод lastIndexOf, который получает целое число и возврощает индекс последнего вхождения
    // данного числа в массив. Если вхождений нет, вернуть -1.

    public int lastIndexOf(int numb) {
        for (int i = this.list.length - 1; i >= 0; i--) {
            if (this.list[i] == numb) {
                return i;
            }
        }
        return -1;
    }

    // Написать метод get, который получает два аргумента 1) индекс элемента в массиве. 2) если в массиве  есть
    // значение  с указанным индексом ( индекс находится в пределах списка),
    // то вернуть его . Если нет, то  вернуть значение по умолчанию.
    public int get(int index, int number) {
        if (index >= 0 && index < this.list.length) {
            return this.list[index];
        } else {
            return number;
        }
    }

    // Добавить метод get, который получает только индекс в качестве аргумента.
    // Значение  по умолчанию должно быть 0
    public int get(int index) {
        return get(index, 0);
    }

    // Добавить метод, который получает новое значение ( новый элемент  numb ) в конец списка.
    // Он создает новый массив newList бльшей длинны, копирует все элементы из текущего списка в новый массив,
    // затем добавляет новый элемент в конец списка, обновляя поле list.
    public void add(int numb) {
        int[] newList = new int[this.list.length + 1];
        copyArray(this.list, newList);
        newList[newList.length - 1] = numb;
        this.list = newList;
    }


    // добавить метод  getMax. Который возвращает максимальное число
    public int getMax() {
        int result = this.list[0];
        for (int elem : this.list) {
            if (elem > result) {
                result = elem;
            }
        }
        return result;
    }

    // создать метод pop который возвращает последний элемент массива
    // и удаляет этот элемент (создает новый массив с длинной на 1 меньше и
    // перекидывает туда все элементы кроме последнего и присваивает его в this.list)
    public int pop() {
        int[] newArray = new int[this.list.length - 1];
        int lastElem = this.list[this.list.length - 1];
        copyArray(this.list, newArray);
        this.list = newArray;
        return lastElem;
    }

    private void copyArray(int[] init, int[] result) {
        int minLength = (init.length > result.length) ? result.length : init.length;
        for (int i = 0; i < minLength; i++) {
            result[i] = init[i];
        }
    }
    // создать метод removeAll, который удаляет все вхождения указанного элемента;
    // создать метод remove, который получает число в качестве аргумента и
// сравнивает его с каждым числом массива
// если совпадение, то выводится в терминал "YES", в ином случае "NO" (на каждое сравнение)
//    public void remove(int value) {
//        for (int elem : this.list) {
//            if (elem == value) {
//                System.out.println("yes");
//            } else {
//                System.out.println("no");
//            }
//        }
// создать метод shiftByIndex, который получает через аргументы индекс в массиве
// и начиная с этого индекса сдвигает все элементы на 1 шаг в лево
/*
    1, 2, 3, 4, 5, 6, 7
    shiftByIndex(2)

    1, 2, 4, 5, 6, 7, 7
*/
//    public void shiftByIndex(int index) {
//        for (int i = index; i < this.list.length - 1; i++) {
//            this.list[i] = this.list[i + 1];
//        }
//    }

    // доработать метод remove таким образом, чтобы в цикле определялся индекс
// удаляемого элемента и все последующие элементы массива сдвигает на один шаг в лево
    public void shiftByIndex(int index) {
        for (int i = index; i < this.list.length - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }

    public void remove(int value) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == value) {
                shiftByIndex(i);
                pop();
                return;
            }
        }
    }

    public void remove2(int value) {
        int index = IndexOf(value);
        if (index != -1) {
            shiftByIndex(index);
            pop();
        }
    }

    // создать метод removeRight, который удаляет первое вхождени с права на лево
    public void removeRight(int value) {
        for (int i = this.list.length - 1; i >= 0; i--) {
            if (this.list[i] == value) {
                shiftByIndex(i);
                pop();
                return;
            }
        }
    }

    // создать метод removeAll, который удаляет все вхождения указанного элемента
    public void removeAll(int value) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] == value) {
                shiftByIndex(i);
                pop();
            }
        }
    }

    public void removeAll2(int value) {
        int i = 0;
        while (i < this.list.length) {
            if (this.list[i] == value) {
                shiftByIndex(i);
                pop();
            } else {
                i++;
            }
        }
    }

    public void removeByIndex(int index) {
        if (index >= 0 && index < this.list.length) {
            shiftByIndex(index);
            pop();
        }
    }
    public void removeAllByIndex(int index){
        for (int  i = 0;  i < this.list.length ; i++) {
            if(i == index){
                removeAll(index);

        }

//    public void removeAllByIndex(int index) {
//        for (int i = 0; i < this.list.length; i++) {
//            if (i == index) {
////                shiftByIndex(i);
////                pop();
//         removeAll(this.list[i]);
            }
        }
    }



//    public void  removeByIndex(int index) {
//        for (int i = 0; i < this.list.length; i++) {
//            if (index < 0 || index >= this.list.length) {
//                System.out.println(index + "Некоректный индекс");
//            }
//            int[] newList = new int[this.list.length - 1];
//            int newIndex = 0;
//            for (int i = 0; i < this.list.length; i++) {
//                if (i != index) {
//                    newList[newIndex] = list[i];
//                    newIndex++;














//        int[] newList = new int[this.list.length - 1];
//        int newIndex = 0;
//        for (int i = 0; i < this.list.length; i++) {
//            if (i != index) {
//                newList[newIndex ] = list[i];
//                newIndex++;
//            }
//        }
//        return newList;

















//Добавить класс CustomStringList со следующим набором методов.
//
//    0. Добавить начальный набор методов и свойств
//
//Добавить конструктор, который получает массив из строк и присваивает его в свойство list.
//    1. Метод check
//
//Данный метод получает в качестве аргумента строку и проверяет, находится ли эта строка в списке строк или нет.
// Если да, метод возвращает true, в ином случае false.
//    2. Метод check
//
//Данный метод получает в качестве аргумента массив из строк и проверяет, находятся ли строки из полученного списка в списке строк list. Если все находятся, метод возвращает true, в ином случае false.
//    3. Метод longestWord
//
//Данный метод не получает аргументов и возвращает самое длинное слово из массива list.
//    4. Метод add
//
//Данный метод получает в качестве аргумента строку и создает новый массив в list, который содержит все старые элементы и новый.
//    5. Метод addIfNotExists
//
//Данный метод получает в качестве аргумента строку и если данной строки нет в list создает новый массив в list, который содержит все старые элементы и новый. В ином случае выводит в терминал сообщение "Строка <значение строки> в массиве уже есть"
//Результат необходимо загрузить на github и ссылку прислать в качестве результата.