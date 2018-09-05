public class Quick {
    public static void main(String[] args)
    {
        int maxSize = 16; // Размер массива
        Quick arr;
        arr = new Quick(maxSize); // Создание массива
        for(int j=0; j<maxSize; j++) // Заполнение массива
        { // случайными числами.
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display(); // Вывод элементов
        arr.quickSort(); // Быстрая сортировка
        arr.display(); // Повторный вывод элементов
    }

    private long[] theArray; // Ссылка на массив
    private int nElems;

    public Quick(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public void display() // Вывод содержимого массива
    {
        System.out.print("A=");
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println();
    }

    public void insert(long value) // Вставка элемента в массив
    {
        theArray[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public void quickSort()
    {
        recQuickSort(0, nElems-1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0) // Если размер <= 1,
            return; // массив отсортирован
        else // Для размера 2 и более
        {
            long pivot = theArray[right]; // Крайний правый элемент
// Разбиение диапазона
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1); // Сортировка левой части
            recQuickSort(partition + 1, right); // Сортировка правой части
        }
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1; // Левая граница (после ++)
        int rightPtr = right; // Правая граница-1 (after --)
        while (true) { // Поиск большего элемента
            while (theArray[++leftPtr] < pivot) ;
            while (rightPtr > 0 && theArray[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp;
        temp = theArray[dex1]; // A копируется в temp
        theArray[dex1] = theArray[dex2]; // B копируется в A
        theArray[dex2] = temp; // temp копируется в B
    }
//--------------------------------------------------------------
}
