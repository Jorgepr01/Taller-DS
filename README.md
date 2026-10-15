# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

---

# Integrante 1: SRP

Se realizaron cambios tanto en la clase Veterinario, ReservaService, DiagnosticoService, FacturacionService, y ReporteService. 
La clase Veterinario incluia metodos que no dependian solamente de la entidad "veterinario", por lo tanto si se necesitaba realizar un cambio en alguno de los metodos incluidos como reservarCita, diagnosticar, etc, entonces se deberia cambiar la clase Veterinario cada vez que cambie la logica de esos metodos o se deban actualizar, lo que ademas no solo podria dañar la integridad de los datos, pero de otros metodos creados ya existentes dentro. Por lo tanto se procedio a eliminar los metodos dentro de Veterinario y se añadieron dentro de nuevas clases especificamente creadas para estos procesos, lo que permite que si alguna vez se requiera modificar alguno de esos metodos, no afecten a ningun otro proceso o clase. Ademas permite que tenga una baja cohesion, lo que la hace poco dependiente y ademas hace que resulte mas facil poder reutilizarlo a futuro si se requiere uno de los metodos dentro de el, contrario a que si incluyera muchos metodos pocos relacionados y dependientes de el.


Preguntas de discusión:

- ¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?

Habia 4 razones,tanto reserva, diagnostico, factura y reporte eran metodos que no dependian solamente de la entidad veterinario. Por ejemplo la reserva dependia de cuantos cupos disponibles habian restantes para ciertos dias, la cantidad de pacientes, etc. Diagnostico dependia de otros factores como la atencion del cliente, su edad, historial medico, no solo del veterinario, reporte de cuantas mascotas hay, su raza, tipo, etc. Y factura ya sea del tipo de servicio que se ofrece, las condiciones comerciales, la naturaleza y fecha donde se realicen, etc.

- ¿Qué ganamos al separar modelo y servicios?

Ganamos integridad de los datos, y tambien evitamos redundancia al tener que modificar el codigo a futuro por actualizaciones de politicas de la empresa, o futuro cambio de servicios. Asi se mantiene una estructura solida y que no depende de un dato redundante

- ¿Qué clase debería cambiar si mañana cambia el formato del reporte?

Habria que cambiar ReporteService debido a que en esta clase gracias al principio aplicado de Single Responsability Principle es la unica que maneja y controla los datos y sintaxis de los reportes



---

# Integrante 2: OCP

## Cambios realizados

- Se eliminaron los if por tipo de tratamiento.
- Se creó una clase para cada tratamiento: vacuna, cirugía, medicamento y fisioterapia.
- Cada clase calcula su costo, impuestos, indicaciones y preparación de sala.
- `CalculadoraCostoTratamiento` y `TratamientoService` usan `ITratamiento`.
- `Main` usa `CirujiaTratamiento` y sigue funcionando.
- No se modificaron las clases de los demás integrantes.

## Respuestas

### ¿Por qué los condicionales repetidos hacen más caro el cambio?

Porque hay que modificar varias clases cada vez que cambia una regla o se agrega un tratamiento. Esto aumenta los errores y dificulta el mantenimiento.

### ¿Qué pasaría si agregamos `Odontologia`?

Se crearía `OdontologiaTratamiento` con sus propias reglas. No sería necesario modificar la calculadora ni agregar nuevos condicionales.

### ¿Cuándo una interfaz ayuda a extender el sistema?

Cuando varias clases comparten las mismas operaciones, pero cada una las implementa de forma diferente. Los servicios usan la interfaz y no dependen de una clase específica.

## Validación

| Criterio | Resultado |
| --- | --- |
| El proyecto compila | Sí |
| No hay condicionales por tipo | Sí |
| Cada tratamiento tiene sus propias reglas | Sí |
| Se pueden agregar tratamientos creando nuevas clases | Sí |
| `Main` funciona | Sí |

Se compiló y ejecutó el proyecto con `javac`. Maven no está disponible en el entorno.


---

# Integrante 3: LSP

Cambios ejecutados en el proyecto de Clínica Veterinaria integrante 3 (Principio de sustitución de Liskov) por Alex Moreno Rocafuerte:

Se detectó una violación del principio de Liskov en la interfaz IAnimal, que obligaba a las subclases que heredaban de la super clase Animal a implementar métodos que no requerían y provocando que se rompa el flujo del programa
Ya que se obligaba a lanzar excepciones.

La solución a esto fue dividir la interfaz IAnimal en pequeñas interfaces más especializadas y relegar la interfaz IAnimal a operaciones comunes.

IAnimal: void moverse();

Las interfaces implementadas fueron: Nadador, Caminador y Volador. Cada una poseía un método especializado asociado a su tipo de animal, esta interfaz obliga a cada clase que la implemente a utilizar su método asociado.

Nadador: void nadar();

Caminador: void caminar();

Volador: void volar();

Para esto también se modificaron las subclases Perro, Gato, Pájaro y Pez para que no lancen una excepción si no que se pueda ejecutar el método acorde a su tipo de manera correcta, manteniendo el flujo del programa.
También se modificó la super clase Animal para ejecutar un método común

Los métodos implementados fueron:

Clase Perro: public void caminar(System.out.println("UN perro puede caminar"););

Clase Gato: public void caminar(System.out.println("UN gato puede caminar"););

Clase Pez: public void nadar(System.out.println("UN pez puede nadar"););

Clase Pajaro: public void volar(System.out.println("Un pajaro puede volar"););

Clase Animal: public void moverse(System.out.println("Un animal puede moverse"););

Así mismo se presentó un cambio en el main para reflejar el mensaje según el tipo de animal correspondiente:

Original:

Animal pez = New Pez (3, "Nemo");
pez.nadar();

Actualización:

Nadador pez = New Pez(3, "Nemo");
pez.nadar();


---

# Integrante 4: ISP y DIP

## Cambios realizados

- Se reemplazó `IServicioClinica` por interfaces enfocadas: `IMascotaService`, `ICitaService`, `IFacturaService`, `IReporteService`, `ITratamientoService` e interfaces específicas para el registro y CRUD de veterinarios.
- `ServicioClinicaCompleto` implementa los contratos de servicio correspondientes.
- `RecepcionService` depende por constructor únicamente de `IMascotaService`, `IVeterinarioRegistro` e `ICitaService`. Se quitaron las operaciones que no usa y que antes lanzaban `UnsupportedOperationException`.
- `Clinica` recibe `IVeterinarioService` e `IBaseDatos` por constructor.
- `GestorReportesClinica` recibe `IBaseDatos` por constructor; ya no crea su propia base de datos.
- `Main` ensambla las implementaciones concretas y las inyecta.

## Respuestas

### ¿Qué problema causa una interfaz gigante en equipos grandes?

Obliga a las clases cliente a conocer operaciones ajenas a sus responsabilidades. Esto aumenta el acoplamiento, hace más probable que una implementación incluya métodos vacíos o que fallen con excepciones, y complica cambios paralelos porque varios equipos dependen de un mismo contrato amplio.

### ¿Por qué `new DirectoBaseDatos()` dificulta cambiar o probar la clase?

Porque `Clinica` elige y construye directamente una implementación concreta. Para probarla o cambiar el mecanismo de persistencia habría que modificar la clase, y no se puede sustituir fácilmente la dependencia por una alternativa controlada en una prueba.

### ¿Qué dependencia debería conocer el código de alto nivel: interfaz o clase concreta?

Debería depender de una abstracción que describa las operaciones que necesita. La composición de la aplicación, como `Main`, elige e inyecta la implementación concreta.

## Validación

| Criterio | Resultado |
| --- | --- |
| El proyecto compila | Sí, con `javac` |
| `RecepcionService` no implementa métodos innecesarios | Sí |
| `Clinica` no construye sus dependencias principales | Sí |
| Las dependencias de clínica y reportes se reciben por constructor | Sí |
| `Main` ejecuta el flujo integrado | Sí |

Maven no está instalado en el entorno. Como comprobación, se compilaron todos los fuentes con `javac` y se ejecutó `clinicaveterinaria.Main`; ambos pasos finalizaron correctamente.
