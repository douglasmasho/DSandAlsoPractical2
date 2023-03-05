public class ClassDataArray {
    Person[] a;
    private int nElems;

    public ClassDataArray(int max){
        a = new Person[max];
        nElems = 0;
    }


    public void DisplayA(){
        for(int j = 0; j < nElems; j++){
            a[j].displayPerson();
        }
    }

    public Person Find(String searchName){
        for(int j = 0; j < nElems; j++){
            if(a[j].getLastName().equals(searchName)){
                return a[j];
            }
        }
        //if at the end of the loop, you don't find it, return null
        return null;
    }


    public boolean Delete(String searchName){
        for(int j = 0; j < nElems; j++){
            if(a[j].getLastName().equals(searchName)){
                for(int k = j; k < nElems; k++){
                    a[k] = a[k+1];
                }
                nElems--;
                return true;
            }
        }

        return false;
    }

    //this method orders by last names
    public void Insert(String lastName, String firstName, int age){
        Person newPerson = new Person(lastName, firstName, age);
        //use compareTo method. If comparing personeOne.getLastName().compareTo(personTwo.getLastName()) is less than 0, that means that personOne's last name comes before person 2's last name.
        for(int j = 0; j < nElems; j++){
            if(a[j].getLastName().compareTo(newPerson.getLastName()) > 0){ //that means you found a person whose lastname is lexicographically greater than the lastname of the person you want to insert
                for(int k = nElems; k > j; k--){
                    a[k] = a[k-1];
                }
                a[j] = newPerson;
                nElems++;
                return;
            }
        }

        //if at the end of the loop, you don't find a lastname greater than the one you want to insert, insert at the end
        a[nElems] = newPerson;
        nElems++;

    }

}
