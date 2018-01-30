public class Protocole {

    String ligneEntree;
    static Integer pile = 0;
    Operateur operateur = new Operateur();

    public int Protocole(String s) {

        int a;
        int b;
        char op;

        String[] ret = s.split(" ");

        for (String r : ret) {
            System.out.println(r);
        }

        if (ret.length == 2) {
            a = pile;
            b = Integer.parseInt(ret[1]);
            op = ret[0].charAt(0);

            pile = operateur.op(a, op, b);
        } else if (ret.length == 3) {
            a = Integer.parseInt(ret[0]);
            b = Integer.parseInt(ret[2]);
            op = ret[1].charAt(0);

            pile = operateur.op(a, op, b);
        } else {
            System.out.println("ERREUR parsing !!! --> (a op b) | (op b)");
            return 0;
        }

        return pile;
    }

    void resetPile(){
        pile = 0;
    }

}
