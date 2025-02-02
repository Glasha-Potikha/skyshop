
package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searched;

    public SearchEngine(int len) {
        searched = new ArrayList<>(len);
    }

    public void add(Searchable searchable) {
        searched.add(searchable);
    }

    public List<Searchable> search(String find) {
        List<Searchable> res = new ArrayList<>(5);

        for (Searchable thing : searched) {
            //если объект включает в себя искомое
            if (thing.searchTerm().contains(find)) {
                //добавляем к спсику
                res.add(thing);
            }
        }
        return res;
    }

    public Searchable searchForTheBestMatch(String find) throws BestResultNotFound {
        //массив, в который положим количество повторений строки в каждом объекте
        int[] results = new int[searched.size()];

        int index = 0;//индекс, с которого начинаем искать подстроку
        //вычисляем количество повторений в каждом объекте
        for (int i = 0; i < searched.size(); i++) {
            String str = searched.get(i).searchTerm();
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
        return searched.get(indexMaxRes);
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
