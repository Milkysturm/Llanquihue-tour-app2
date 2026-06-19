![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# Llanquihue Tour – Organización Modular y Librería Personalizada (Semana 5)

## Autor del proyecto
- **Nombre completo:** Olga Rivas Ahumada
- **Carrera:** Analista Programador Computacional
- **Asignatura:** Desarrollo Orientado a Objetos I

---

## Descripción general del sistema

**Llanquihue Tour** es una agencia de turismo de la Región de Los Lagos que trabaja junto a guías turísticos, proveedores de transporte y operadores locales, formando una amplia red de colaboración. La agencia necesita una herramienta para registrar, consultar y filtrar de manera eficiente la información de sus tours y de los colaboradores asignados a cada uno.

Este proyecto, correspondiente a la actividad de la **Semana 5** de *Desarrollo Orientado a Objetos I*, es la continuación directa del trabajo previo. Consolida competencias en **modularidad**, **reutilización de código** y **organización por paquetes funcionales**. Los datos se leen desde un archivo externo, se cargan en una **colección dinámica** (`ArrayList`) y se aplican operaciones automatizadas de **recorrido, búsqueda y visualización por consola**. El sistema incorpora además una pequeña **librería de utilidades propia** (paquete `util`) y aplica **composición** entre clases: cada `Tour` contiene un `Guia`, un `Proveedor` y un `Operador`.

---

## Estructura del proyecto

El código se organiza en paquetes funcionales que separan responsabilidades:

```plaintext
📁 src/
├── model/        # Clases del dominio
│   ├── Tour.java         # Representa un tour; CONTIENE Guia, Proveedor y Operador (composición)
│   ├── Guia.java         # Guía turístico asignado al tour
│   ├── Proveedor.java    # Proveedor de transporte del tour
│   └── Operador.java     # Operador local del tour
├── util/         # Librería de utilidades propia
│   └── Validador.java    # Métodos estáticos de validación reutilizables
├── service/      # Lógica de negocio
│   └── GestorTours.java  # Lee el archivo, crea objetos y realiza búsquedas
├── app/          # Punto de entrada
│   └── Main.java         # Ejecuta el sistema y muestra resultados
└── resources/    # Recursos del proyecto
    └── tours.txt         # Archivo de datos (6 tours separados por ;)
```

---

## Paquetes y clases implementadas

| Clase | Paquete | Rol en el sistema |
|-------|---------|-------------------|
| `Tour` | `model` | Representa un tour (nombre, tipo, precio, cupos) y **contiene** un `Guia`, un `Proveedor` y un `Operador` como atributos (composición). |
| `Guia` | `model` | Representa al guía asignado a un tour (nombre, idioma, años de experiencia). |
| `Proveedor` | `model` | Representa al proveedor de transporte del tour (empresa, tipo de transporte). |
| `Operador` | `model` | Representa al operador local del tour (nombre, comuna). |
| `Validador` | `util` | Librería propia con métodos estáticos de validación (texto no vacío, número no negativo, cantidad de campos). |
| `GestorTours` | `service` | Lee `tours.txt`, construye los objetos con sus colaboradores y ofrece búsquedas por tipo, nombre y precio. |
| `Main` | `app` | Punto de entrada. Carga los datos y muestra el catálogo y las búsquedas por consola. |

### Conceptos aplicados

- **Modularidad:** el código se separa en cuatro paquetes funcionales (`model`, `util`, `service`, `app`).
- **Composición:** la clase `Tour` contiene tres objetos (`Guia`, `Proveedor`, `Operador`), reflejando la red de colaboración de la agencia.
- **Librería personalizada:** el paquete `util` agrupa validaciones reutilizables en la clase `Validador`.
- **Colecciones:** uso de `ArrayList` para almacenar dinámicamente los objetos `Tour`.
- **Lectura de archivos:** `BufferedReader` recorre el archivo línea por línea.
- **Búsqueda y filtrado:** métodos que devuelven subconjuntos según tipo, precio o nombre.
- **Eliminación:** método que quita un tour de la colección por su nombre, completando las operaciones de inserción, acceso, recorrido, búsqueda y eliminación.
- **Validación con try-catch:** manejo de errores de lectura y de formato numérico.
- **Encapsulamiento:** todos los atributos son privados, con getters y setters.
- **Documentación:** todas las clases están comentadas con **Javadoc**.

---

## Formato del archivo `tours.txt`

Cada línea representa un tour con su guía, proveedor y operador, con los campos separados por punto y coma (`;`):

```plaintext
nombre;tipo;precio;cupos;nombreGuia;idiomaGuia;aniosExperiencia;empresaProveedor;tipoTransporte;nombreOperador;comunaOperador
```

Ejemplo:
```plaintext
Ruta Gastronomica Llanquihue;gastronomico;25000;12;Valentina Munoz;Espanol;6;Transportes del Sur;Bus;Cocina Llanquihue;Llanquihue
```

---

## Cómo clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

   ```bash
   git clone https://github.com/Milkysturm/llanquihue-tour.git
   ```

2. Abre el proyecto en **IntelliJ IDEA** o **VS Code**.

3. Verifica que la carpeta `src` esté marcada como *Sources Root*.

4. Ejecuta la clase `Main.java`, ubicada en el paquete `app`, **desde la raíz del proyecto** para que encuentre correctamente la ruta `src/resources/tours.txt`.

> **Alternativa por línea de comandos** (desde la raíz del proyecto):
> ```bash
> javac -d out src/model/Guia.java src/model/Proveedor.java src/model/Operador.java src/model/Tour.java src/util/Validador.java src/service/GestorTours.java src/app/Main.java
> java -cp out app.Main
> ```

---

## Versión de distribución (.jar)

El proyecto incluye una versión de distribución ejecutable (`LlanquihueTourApp.jar`).

**Para ejecutarla**, ubica el `.jar` en la raíz del proyecto (junto a la carpeta `src`) y ejecuta:

```bash
java -jar LlanquihueTourApp.jar
```

> El programa lee los datos desde `src/resources/tours.txt`, por lo que el
> `.jar` debe ejecutarse desde la raíz del proyecto, donde está esa carpeta.

**Para regenerar el .jar** desde el código fuente (requiere el JDK completo):

```bash
# 1. Compilar las clases
javac -d out src/model/*.java src/util/*.java src/service/*.java src/app/*.java

# 2. Generar el jar ejecutable indicando la clase principal
jar cfe LlanquihueTourApp.jar app.Main -C out .
```

---

## Salida esperada por consola

```text
=== CATALOGO COMPLETO DE TOURS ===
Tour{nombre='Ruta Gastronomica Llanquihue', tipo='gastronomico', precio=$25000, cupos=12, guia=Valentina Munoz (Espanol, 6 anios de experiencia), proveedor=Transportes del Sur (Bus), operador=Cocina Llanquihue - Llanquihue}
... (6 tours en total) ...

Total de tours cargados: 6

=== BUSQUEDA: TOURS GASTRONOMICOS ===
(2 tours)

=== BUSQUEDA: TOURS ECONOMICOS (precio <= $20.000) ===
(2 tours)

=== BUSQUEDA POR NOMBRE: 'Excursion Volcan Osorno' ===
Tour encontrado: Excursion Volcan Osorno
  Guia a cargo : Camila Soto (Ingles, 8 anios de experiencia)
  Transporte   : Andes Transfer (Van)
  Operador     : Montana Viva - Puerto Varas
```

---

**Repositorio GitHub:** https://github.com/Milkysturm/llanquihue-tour
**Fecha de entrega:** [completa con tu fecha]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I
