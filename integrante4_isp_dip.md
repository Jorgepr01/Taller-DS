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