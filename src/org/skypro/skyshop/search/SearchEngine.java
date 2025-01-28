
package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searched;

    public SearchEngine(int len) {
        searched = new Searchable[len];
    }

    public void add(Searchable searchable) {
        if (searched[searched.length - 1] != null) {
            System.out.println("Система поиска переполнена - невозможно добавить объект");
        }
        for (int i = 0; i < searched.length; i++) {
            if (searched[i] == null) {
                searched[i] = searchable;
                break;
            }
        }
    }

    public Searchable[] search(String find) {
        Searchable[] res = new Searchable[5];
        int count = 0;
        for (Searchable thing : searched) {
            //если объект включает в себя искомое
            if (thing.searchTerm().contains(find)) {
                //всатвляем его в свободное место массива
                res[count] = thing;
                //если последнее место массива занято, результат готов
                if (count == 4) {
                    return res;
                }
                count++;
            }
        }
        return res;
    }

    public Searchable searchForTheBestMatch(String find) throws BestResultNotFound {
        //массив, в который положим количество повторений строки в каждом объекте
        int[] results = new int[searched.length];

        int index = 0;//индекс, с которого начинаем искать подстроку
        //вычисляем количество повторений в каждом объекте
        for (int i = 0; i < searched.length; i++) {
            String str = searched[i].searchTerm();
            int indexFind = str.indexOf(find, index); //индексПодстроки
            while (indexFind != -1) {
                results[i]++;
                index = index + find.length();
                indexFind = str.indexOf(find, index);
            }
            index = 0;
        }

        int indexMaxRes = searchIndexMaxInt(results);
        if (indexMaxRes < 0) {
            throw new BestResultNotFound(find);
        }

        return searched[indexMaxRes];
    }

    public static int searchIndexMaxInt(int[] num) {
        int max = 0;
        int index = -1;
        for (int i = 0; i < (num.length); i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        return index;
    }
}
