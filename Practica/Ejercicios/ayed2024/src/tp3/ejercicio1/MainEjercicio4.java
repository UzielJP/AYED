package tp3.ejercicio1;

public class MainEjercicio4 {
    public static void main(String[] args) {
        // Crear la raíz del árbol
        GeneralTree<AreaEmpresa> root = new GeneralTree<>(new AreaEmpresa("Dirección General", 5));

        // Crear áreas principales
        GeneralTree<AreaEmpresa> finanzas = new GeneralTree<>(new AreaEmpresa("Finanzas", 8));
        GeneralTree<AreaEmpresa> operaciones = new GeneralTree<>(new AreaEmpresa("Operaciones", 10));
        GeneralTree<AreaEmpresa> marketing = new GeneralTree<>(new AreaEmpresa("Marketing", 6));
        GeneralTree<AreaEmpresa> recursosHumanos = new GeneralTree<>(new AreaEmpresa("Recursos Humanos", 7));

        // Agregar áreas principales a la raíz
        root.addChild(finanzas);
        root.addChild(operaciones);
        root.addChild(marketing);
        root.addChild(recursosHumanos);

        // Crear subáreas para Finanzas
        GeneralTree<AreaEmpresa> contabilidad = new GeneralTree<>(new AreaEmpresa("Contabilidad", 12));
        GeneralTree<AreaEmpresa> tesorería = new GeneralTree<>(new AreaEmpresa("Tesorería", 15));
        finanzas.addChild(contabilidad);
        finanzas.addChild(tesorería);

        // Subáreas de Contabilidad
        contabilidad.addChild(new GeneralTree<>(new AreaEmpresa("Cuentas por Cobrar", 18)));
        contabilidad.addChild(new GeneralTree<>(new AreaEmpresa("Cuentas por Pagar", 14)));

        // Subáreas de Operaciones
        GeneralTree<AreaEmpresa> logística = new GeneralTree<>(new AreaEmpresa("Logística", 20));
        GeneralTree<AreaEmpresa> producción = new GeneralTree<>(new AreaEmpresa("Producción", 25));
        operaciones.addChild(logística);
        operaciones.addChild(producción);

        // Subáreas de Logística
        logística.addChild(new GeneralTree<>(new AreaEmpresa("Transporte", 22)));
        logística.addChild(new GeneralTree<>(new AreaEmpresa("Almacén", 24)));

        // Subáreas de Marketing
        GeneralTree<AreaEmpresa> publicidad = new GeneralTree<>(new AreaEmpresa("Publicidad", 16));
        GeneralTree<AreaEmpresa> investigaciónMercado = new GeneralTree<>(new AreaEmpresa("Investigación de Mercado", 18));
        marketing.addChild(publicidad);
        marketing.addChild(investigaciónMercado);

        // Subáreas de Recursos Humanos
        GeneralTree<AreaEmpresa> reclutamiento = new GeneralTree<>(new AreaEmpresa("Reclutamiento", 10));
        GeneralTree<AreaEmpresa> capacitación = new GeneralTree<>(new AreaEmpresa("Capacitación", 12));
        recursosHumanos.addChild(reclutamiento);
        recursosHumanos.addChild(capacitación);

        // Subáreas adicionales para completar los 30 nodos
        reclutamiento.addChild(new GeneralTree<>(new AreaEmpresa("Selección", 14)));
        reclutamiento.addChild(new GeneralTree<>(new AreaEmpresa("Onboarding", 8)));

        capacitación.addChild(new GeneralTree<>(new AreaEmpresa("Cursos Internos", 9)));
        capacitación.addChild(new GeneralTree<>(new AreaEmpresa("Capacitación Externa", 11)));

        publicidad.addChild(new GeneralTree<>(new AreaEmpresa("Publicidad Digital", 13)));
        publicidad.addChild(new GeneralTree<>(new AreaEmpresa("Publicidad Impresa", 10)));

        investigaciónMercado.addChild(new GeneralTree<>(new AreaEmpresa("Encuestas", 14)));
        investigaciónMercado.addChild(new GeneralTree<>(new AreaEmpresa("Focus Groups", 16)));

        AnalizarArbol n = new AnalizarArbol();
        System.out.println("El mayor promedio entre los hijos es de: "+n.devolverMaximoPromedio(root));
        
    }
}
