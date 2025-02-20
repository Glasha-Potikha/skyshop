
package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searched;

    public SearchEngine() {
        searched = new LinkedHashSet<>();
        //Linked потому что в searchForTheBestMatch важен порядок элементов
    }

    public void add(Searchable searchable) {
        searched.add(searchable);
    }

    public TreeSet<Searchable> search(String find) {
        TreeSet res = searched.stream()
                .filter(thing -> thing.searchTerm().contains(find))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LengthStringComparator())));
        return res;
    }

    public void printResSearch(String find) {
        System.out.println("\nПоиск по слову - " + find + ":");
        TreeSet<Searchable> res = search(find);
        if (res.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            for (Searchable r : res) {
                System.out.println(r);
            }
        }
        System.out.println();
    }

    public Searchable searchForTheBestMatch(String find) throws BestResultNotFound {
        //массив, в который положим количество повторений строки в каждом объекте
        int[] results = new int[searched.size()];
        int i = 0;
        int index = 0;//индекс, с которого начинаем искать подстроку
        for (Searchable s : searched) {
            String str = s.searchTerm();
            int indexFind = str.indexOf(find, index); //индексПодстроки
            while (indexFind != -1) {
                results[i]++;
                index = index + find.length();
                indexFind = str.indexOf(find, index);
            }
            i++;
        }
        int indexMaxRes = searchIndexMaxInt(results);
        if (indexMaxRes < 0) {
            throw new BestResultNotFound(find);
        }
        i = 0;
        for (Searchable s : searched) {
            //останавливаемся на элементе с максимальным количество повторений
            if (i == indexMaxRes) {
                return s;
            }
            i++;
        }
        return null;
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
