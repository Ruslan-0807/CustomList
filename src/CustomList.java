import  java.util.Arrays;

public   class CustomList {
    public int[] list;

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

    public void removeAllByIndex(int index) {
        for (int i = 0; i < this.list.length; i++) {
            if (i == index) {
                removeAll(index);

            }
        }
    }

    // / реализовать метод reverse, который разворачивает массив this.list
    // // реализовать метод reverse, который разворачивает массив this.list
    //
    //// создать метод reverse (ничего не получает и ничего не возвращает)
    //// выводит в треминал числа из массива list (по отдельности)
//добавить процесс замены элементов
//    reverse():
//
//    Этот метод инвертирует порядок элементов в массиве.
//    Используется цикл, который проходит половину массива.
//    На каждой итерации значения элементов меняются местами, начиная с крайних и двигаясь к центру массива.
    public void reverse() {
        int i = 0;
        while (i < this.list.length - 1 - i) {

            int tmp = this.list[i];
            this.list[i] = this.list[this.list.length - 1 - i];
            this.list[this.list.length - 1 - i] = tmp;
            i++;
        }
    }
    //    bubbleSort():
//
//    Этот метод сортирует массив в порядке возрастания с использованием сортировки пузырьком.
//    Имеется два вложенных цикла. Внешний цикл проходит по всем элементам массива.
//    Внутренний цикл сравнивает текущий элемент с следующим и меняет их местами, если текущий элемент больше следующего.
//    По мере прохождения внутреннего цикла наименьший элемент "всплывает" на свое место в конце массива.
    public void bubbleSort() {
        for (int i = 0; i < this.list.length; i++) {
            for (int j = 0; j < this.list.length - 1 - i; j++) {
                if (this.list[j] > this.list[j + 1]) {
                    int tmp = this.list[j];
                    this.list[j] = this.list[j + 1];
                    this.list[j + 1] = tmp;
                }
            }
            System.out.println(this);
        }
    }
    //    selectionSort():
//
//    Этот метод сортирует массив в порядке убывания с использованием сортировки выбором.
//    Имеется два вложенных цикла. Внешний цикл проходит по всем элементам массива.
//    Внутренний цикл находит максимальный элемент в текущем подмассиве и запоминает его значение и индекс.
//    После завершения внутреннего цикла меняется местами максимальный элемент с
//    последним элементом текущего подмассива.
//    Обратите внимание, что в методе selectionSort()
//    также выводится информация о максимальном элементе и его индексе на каждой итерации внешнего цикла.
//    Это, вероятно, используется для отладки или для демонстрации процесса сортировки.
    //    написать двойной цикл, который выводит значения лесенкой
    public void selection() {
        for (int i = 0; i < this.list.length; i++) {
            int max = this.list[0];
            int maxIndex = 0;
            for (int j = 0; j < list.length - i; j++) {
                if (max < this.list[j]) {
                    max = this.list[j];
                    maxIndex = j;
                }
            }
            swap(maxIndex, this.list.length - i - 1);
//            int lastIndex = this.list.length - i
//            int temp = this.list[lastIndex];
//            this.list[lastIndex] = this.list[maxIndex];
//            this.list[maxIndex] = temp;
        }
    }
    public void swap(int num1, int num2) {
        for (int i = 0; i < this.list.length; i++) {
            int temp = this.list[num1];
            this.list[num1] = this.list[num2];
            this.list[num2] = temp;
            //           System.out.println(this);
        }
    }
    public void bubbleSort(boolean desc) {
        for (int i = 0; i < this.list.length; i++) {
            for (int j = 0; j < this.list.length - 1 - i; j++) {
                if (this.list[j] > this.list[j + 1] == desc) {
                    swap(j, j + 1);
                }
            }
        }
    }
    public void selectionSort(boolean desc) {
        for (int i = 0; i < this.list.length; i++) {
            int target = this.list[0];
            int targetIndex = 0;
            for (int j = 0; j < list.length - i; j++) {
                if (target < this.list[j] == desc) {
                    target = this.list[j];
                    targetIndex = j;
                }
            }
            swap(targetIndex, this.list.length - i - 1);
        }
    }
    // создать метод invert, который проходится по всем элементам
    // массива и меняет у них знак ( -5 -> 5, 5 -> -5)
    public void invert() {
        for (int i = 0; i < this.list.length; i++) {
            this.list[i] *= -1;
        }
    }

    // создать метод positive который превращает все элементы в положительные
    // использовать Math нельзя
    public void positive() {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] < 0) ;
            this.list[i] *= -1;
        }
    }
    // создать метод invert, который проходится по всем элементам
    // массива и меняет у них знак ( -5 -> 5, 5 -> -5)
    // создать метод changeSign который получает булевый аргумент
    // если true, то все числа делаем положительными
    // в ином случае отрицательными
    public void changeSign(boolean type) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i] < 0 == true) {
                this.list[i] *= -1;
            }
        }
    }
    // создать метод insertionSort который используя цикл по индексам выводит все значения массива в терминал
    // написать алгоритм который для каждого числа из массива выводит значение меньше этого числа которое ближе всего к нему с лева
// если такого числа нет вывести отбивку "такого числа
    public void insertionSort() {
        for (int i = 0; i < this.list.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (this.list[j] < this.list[i]) {

                }
                System.out.printf("%d - %d%n", this.list[i], this.list[j]);
                break;
            }
        }
    }
    public void insertionSort1() {
        for (int i = 1; i < this.list.length; i++) {
            int key = this.list[i];
            int j = i-1;
            while (j >= 0 && this.list[j] > key ){
                this.list[j+1] = this.list[j];
                j--;
            }
            this.list[j+1] = key;
            System.out.printf("[%d)%d] %s%n" ,i , key,this);
        }
    }
}










        //       return num1;


//
//        System.out.println(desc);
//    }
//    public void selection (boolean desc){
//        selection(false);
//        System.out.println("hjk" + desc);



    // доработать метод reverse таким образом, чтобы выводились
// равноудаленные от центра массива значения


//    public void removeAllByIndex(int index) {
//        for (int i = 0; i < this.list.length; i++) {
//            if (i == index) {
////                shiftByIndex(i);
////                pop();
//         removeAll(this.list[i]);


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

















