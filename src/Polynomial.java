import java.util.NoSuchElementException;

public class Polynomial {
    private Nodo root;
    private int grad;

    public Polynomial() {

    }

    public Polynomial(int coef[]){
        int lengthPol = coef.length;
        grad = lengthPol;
        for (int i = (lengthPol-1); i >= 0 ; i--){
            if(coef[i] !=0){
                Nodo n = new Nodo(coef[i],i+1);
                n.next = root;
                root = n;
            }else{continue;}
        }
    }

    public int getCoefficient(int grad){
        Nodo p = root;
        if (grad < 0 || grad > this.grad)
        {
            throw new NoSuchElementException();
        }else{
            while (p!=null){
                if(p.exp == grad){
                    return p.coef;
                }
                p = p.next;
            }
        }
        return 0;
    }

    public void setCoefficient(int grad, int value){
        Nodo p = root;
        Nodo q = root;
        if (grad < 0 || grad > this.grad)
        {
            throw new NoSuchElementException();
        }else{
            boolean change = false;
            while (p!=null){
                q=p;
                if (p.next != null){
                    p=p.next;
                    if(p.exp > grad && q.exp < grad){
                        Nodo n = new Nodo(value, grad);
                        q.next = n;
                        n.next = p;
                        change=true;
                        break;
                    }else if(q.exp==grad){
                        q.coef = value;
                        change=true;
                        break;
                    }else if(p.exp == grad){
                        p.coef = value;
                        change=true;
                        break;
                    }
                }else{
                    if(change==false){
                        Nodo n = new Nodo(value, grad);
                        p.next = n;
                    }
                }
                }

            }
    }

    public float valueOf(float x){
        Nodo p = root;
        float valor = 0;
        while (p!=null) {
            valor += p.coef * Math.pow(x,p.exp);
            p = p.next;
        }
        return valor;
    }

    public Polynomial add(Polynomial pol){
        Polynomial a = this;
        Polynomial c = new Polynomial();
        Nodo x = a.root;
        Nodo y = pol.root;
        Nodo q;
        while (x!=null || y !=null){
            Nodo t = null;
            if      (x == null)     { t = new Nodo(y.coef, y.exp);  y = y.next; }
            else if (y == null)     { t = new Nodo(x.coef, x.exp);  x = x.next; }
            else if (x.exp > y.exp) { t = new Nodo(x.coef, x.exp);  x = x.next; }
            else if (x.exp < y.exp) { t = new Nodo(y.coef, y.exp);  y = y.next; }

            else {
                int coef = x.coef + y.coef;
                int exp  = x.exp;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Nodo(coef, exp);
            }
            t.next = c.root;
            c.root = t;
        }
        return c;
    }

    public boolean equals(Object x){
        if(x.getClass() == this.getClass()){
                return true;

        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        return grad==0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Nodo p = root;
        while (p != null){
            sb.append(Math.abs(p.coef));
            sb.append("X^");
            sb.append(p.exp);
            p = p.next;
            if(p!=null){
                if (p.coef>0)
                {
                    sb.append(" + ");
                }else if(p.coef<0){sb.append(" - ");}
            }
        }
        sb.append("]");
        return sb.toString();
    }


}

class Nodo{
    int coef;
    int exp;
    Nodo next;

    public Nodo(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}
