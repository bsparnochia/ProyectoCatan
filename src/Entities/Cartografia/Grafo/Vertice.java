    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Entities.Cartografia.Grafo;

    import java.util.Objects;

    /**
     *
     * @author Brian
     */
    public class Vertice {
        private String nombre;
        private int id;
        private static final int NO_DEFINIDO=-1;


        public Vertice(String nombre) {
            this.nombre = nombre;
            this.id = NO_DEFINIDO;
        }

            public Vertice(String nombre, int id) {
            this.nombre = nombre;
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Vertice{" + "nombre=" + nombre + ", id=" + id + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vertice other = (Vertice) obj;
            return Objects.equals(this.nombre, other.nombre);
        }


    }
