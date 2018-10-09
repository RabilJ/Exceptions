public class main {
    public static void main(String[] args) {
        int[] tablica = new int[]{1, 2, 3};

      try {
            wyswietlElement(tablica, 3);
      } catch (PozaZakresemTablicyException e) {
            System.out.println("Poza zakresem");
            e.printStackTrace();
        }
    }
        static void wyswietlElement (int[] tab, int index) throws PozaZakresemTablicyException {
            if (tab.length < index) {
                System.out.println(tab[index]);
            } else {
                throw new PozaZakresemTablicyException("Tablica ma "+ tab.length+ " elementów,a poproszono o element nr."+index);
            }
        }
        }