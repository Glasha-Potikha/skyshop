package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searched;

    public SearchEngine(int len) {
        searched = new Searchable[len];
    }

    public void add(Searchable searchable){
        if (searched[searched.length-1] != null){
            System.out.println("Система поиска переполнена - невозможно добавить объект");
        }
        for (int i = 0; i< searched.length; i++){
            if(searched[i] == null){
                searched[i] = searchable;
                break;
            }
        }
    }

    public Searchable[] search(String find){
        Searchable[] res = new Searchable[5];
        int count = 0;
        for(Searchable thing:searched){
            //если объект включает в себя искомое
            if(thing.searchTerm().contains(find)){
                //всатвляем его в свободное место массива
                        res[count]=thing;
                    //если последнее место массива занято, результат готов
                        if (count == 4){
                            return res;
                        }
                        count++;
            }
        }
        return res;
    }
}
