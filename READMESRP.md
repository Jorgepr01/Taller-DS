Se realizaron cambios tanto en la clase Veterinario, ReservaService, DiagnosticoService, FacturacionService, y ReporteService. 
La clase Veterinario incluia metodos que no dependian solamente de la entidad "veterinario", por lo tanto si se necesitaba realizar un cambio en alguno de los metodos incluidos como reservarCita, diagnosticar, etc, entonces se deberia cambiar la clase Veterinario cada vez que cambie la logica de esos metodos o se deban actualizar, lo que ademas no solo podria dañar la integridad de los datos, pero de otros metodos creados ya existentes dentro. Por lo tanto se procedio a eliminar los metodos dentro de Veterinario y se añadieron dentro de nuevas clases especificamente creadas para estos procesos, lo que permite que si alguna vez se requiera modificar alguno de esos metodos, no afecten a ningun otro proceso o clase. Ademas permite que tenga una baja cohesion, lo que la hace poco dependiente y ademas hace que resulte mas facil poder reutilizarlo a futuro si se requiere uno de los metodos dentro de el, contrario a que si incluyera muchos metodos pocos relacionados y dependientes de el.


Preguntas de discusión:

- ¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?

Habia 4 razones,tanto reserva, diagnostico, factura y reporte eran metodos que no dependian solamente de la entidad veterinario. Por ejemplo la reserva dependia de cuantos cupos disponibles habian restantes para ciertos dias, la cantidad de pacientes, etc. Diagnostico dependia de otros factores como la atencion del cliente, su edad, historial medico, no solo del veterinario, reporte de cuantas mascotas hay, su raza, tipo, etc. Y factura ya sea del tipo de servicio que se ofrece, las condiciones comerciales, la naturaleza y fecha donde se realicen, etc.

- ¿Qué ganamos al separar modelo y servicios?

Ganamos integridad de los datos, y tambien evitamos redundancia al tener que modificar el codigo a futuro por actualizaciones de politicas de la empresa, o futuro cambio de servicios. Asi se mantiene una estructura solida y que no depende de un dato redundante

- ¿Qué clase debería cambiar si mañana cambia el formato del reporte?

Habria que cambiar ReporteService debido a que en esta clase gracias al principio aplicado de Single Responsability Principle es la unica que maneja y controla los datos y sintaxis de los reportes


