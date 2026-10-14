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

