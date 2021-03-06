//Juan Carlos Quirino Carrasco - A01632369
//Brian Reyes Gálvez - A01633401
//Programacion orientada a objetos
//Proyecto Parcial
import javax.swing.*;

public class Principal {
    static String[] opciones={"Agregar contacto","Buscar contacto","Borrar contacto","Salir"}; //Crear las opciones para usar un for luego
    static int opcion; //Para el case
    private static void imprimeMenu(){
        opcion=JOptionPane.showOptionDialog(null,"Elige una opción:","Bienvenido!",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,opciones,opciones[0]); //Texto, Título 
    }
    
    private static Contacto pideContacto() throws NullPointerException{
        
        String[] datos= {"Nombre:","Apellido:","Categoría:","Correo:","Teléfono:","Celular:","Dirección:","Nota:"};
        boolean nullFlag = true;
        for(int i=0;i<datos.length;i++){
            datos[i]=JOptionPane.showInputDialog(null,"Ingresa "+datos[i]); //Recorremos el for para mostrar las opciones y lo sobreescribimos para llamar al constructor
            if (!datos[i].equals("")) {nullFlag = false;}
        }
        if (nullFlag) {throw new NullPointerException("");}
        Contacto c= new Contacto(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        return c;
    }
    
    public static void main(String[] Args){
        Agenda a=new Agenda();
        boolean k=true;
        do{
            imprimeMenu();
            switch(opcion){
                case -1:
                    k=false;
                    break;
                case 0:
                    try {
                        a.agregarContacto(pideContacto());
                    }
                    catch (NullPointerException ex){
                        JOptionPane.showMessageDialog(null,"Error al ingresar contacto","Error",JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    JOptionPane.showMessageDialog(null,"Contacto agregado satisfactoriamente");
                    break;
                case 1:
                    String d=JOptionPane.showInputDialog(null,"Ingresa dato a buscar: ");
                    a.buscarContacto(d);
                    break;
                case 2:
                    a.buscarContacto("");
                    try{
                    int o=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el numero del contacto a borrar"));
                        if (!a.removerContacto(o-1)) {throw new NumberFormatException("");}
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Error al eliminar contacto, contacto no encontrado","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    k=false;
                    break;
                   
            }
        }        
        while(k==true);
    }
}
