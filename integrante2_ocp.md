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
