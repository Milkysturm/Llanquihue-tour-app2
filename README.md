<p align="center">
  <img src="https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png" alt="Duoc UC" width="220"/>
</p>

<h1 align="center">LlanquihueTourApp</h1>
<h3 align="center">Semana 7 — Aplicando polimorfismo y colecciones genéricas</h3>

---

## Autor

| | |
|---|---|
| **Estudiante** | Olga Pamela Rivas Ahumada |
| **Asignatura** | Desarrollo Orientado a Objetos I (DOO I) |
| **Carrera** | Analista Programador Computacional |
| **Institución** | Duoc UC |
| **Repositorio** | [github.com/Milkysturm/llanquihue-tour-app2](https://github.com/Milkysturm/Llanquihue-tour-app2) |

---

## Descripción del proyecto

**Llanquihue Tour** es una agencia de turismo de la comuna de Llanquihue, Región de Los Lagos.
Este sistema simula la gestión de sus servicios turísticos y se construye semana a semana
aplicando progresivamente los conceptos de la Programación Orientada a Objetos.

En esta **Semana 7** el sistema avanza hacia una versión funcional que **almacena distintos
tipos de servicios turísticos en una misma colección genérica** y los **recorre de forma
polimórfica**, invocando métodos sobrescritos desde referencias de la superclase. La jerarquía
queda preparada para escalar con nuevas subclases sin modificar el código existente.


---

## Conceptos aplicados esta semana

- **Clase abstracta:** `ServicioTuristico` se declara `abstract`, por lo que no puede instanciarse y obliga a sus subclases a implementar el comportamiento propio.
- **Polimorfismo y sobrescritura:** el método abstracto `mostrarInformacion()` es sobrescrito con `@Override` en cada subclase; el recorrido se hace sobre referencias de tipo `ServicioTuristico`.
- **Colección genérica:** `List<ServicioTuristico>` almacena objetos de subclases distintas y se recorre con un bucle `for-each` (sin `instanceof`).
- **Excepciones personalizadas:** `ServicioInvalidoException` (checked) y `GestorServiciosException` (unchecked) reemplazan las impresiones por consola ante datos inválidos.
- **Registro de auditoría:** `RegistroAuditoria` acumula los eventos del sistema; solo la capa `ui` decide mostrarlos.
- **Encapsulamiento y separación de responsabilidades:** atributos privados, getters/setters, `toString()`, y arquitectura en paquetes.

---

## Estructura de paquetes y clases

```
src/
├── model/
│   ├── ServicioTuristico.java      (superclase ABSTRACTA + mostrarInformacion abstracto)
│   ├── RutaGastronomica.java       (@Override mostrarInformacion)
│   ├── PaseoLacustre.java          (@Override mostrarInformacion)
│   └── ExcursionCultural.java      (@Override mostrarInformacion)
├── data/
│   └── GestorServicios.java        (List<ServicioTuristico> + carga + auditoría)
├── exception/
│   ├── ServicioInvalidoException.java   (CHECKED)
│   └── GestorServiciosException.java    (UNCHECKED)
├── util/
│   ├── Validador.java              (validaciones reutilizables, sin consola)
│   ├── FormatoMoneda.java          (formato de peso chileno: $25.000)
│   └── RegistroAuditoria.java      (log de eventos en memoria)
└── ui/
    └── Main.java                   (única capa que imprime por consola)
```

| Clase | Paquete | Rol |
|---|---|---|
| `ServicioTuristico` | `model` | Superclase abstracta; define `mostrarInformacion()` abstracto y valida datos en el constructor. |
| `RutaGastronomica` | `model` | Subclase; sobrescribe `mostrarInformacion()` con detalle gastronómico. |
| `PaseoLacustre` | `model` | Subclase; sobrescribe `mostrarInformacion()` con detalle lacustre. |
| `ExcursionCultural` | `model` | Subclase; sobrescribe `mostrarInformacion()` con detalle cultural. |
| `GestorServicios` | `data` | Mantiene la colección polimórfica; carga 6 servicios y registra eventos sin imprimir. |
| `ServicioInvalidoException` | `exception` | Excepción comprobada para datos de servicio inválidos. |
| `GestorServiciosException` | `exception` | Excepción no comprobada para errores de uso del gestor. |
| `Validador` | `util` | Métodos estáticos de validación, sin estado ni consola. |
| `FormatoMoneda` | `util` | Da formato de peso chileno a los precios (`$25.000`). |
| `RegistroAuditoria` | `util` | Acumula eventos `[INFO]/[WARN]/[ERROR]` en memoria. |
| `Main` | `ui` | Punto de entrada; recorre la colección polimórficamente e imprime resultados y auditoría. |

---

## Salida esperada por consola (resumen)

```
====================================================
   LLANQUIHUE TOUR - Gestion de Servicios (S7)
   Polimorfismo y colecciones genericas
====================================================

Servicios cargados: 6

----- RECORRIDO POLIMORFICO -----

1. [Ruta Gastronomica] Sabores de Llanquihue
   Ubicacion : Llanquihue
   Cocina    : Cocina del sur de Chile
   Duracion  : 4 h
   Precio    : $25.000
   Incluye degustaciones en productores locales.

2. [Paseo Lacustre] Navegacion al atardecer
   ...

----- REGISTRO DE AUDITORIA -----
[INFO]  Servicio agregado: Sabores de Llanquihue (Ruta Gastronomica).
[INFO]  Servicio agregado: Navegacion al atardecer (Paseo Lacustre).
...
====================================================
   Fin de la ejecucion
====================================================
```

Cada elemento de la lista ejecuta la versión de `mostrarInformacion()` correspondiente a su
tipo real, demostrando el **polimorfismo en tiempo de ejecución**.

---

## Instrucciones para compilar y ejecutar

### En IntelliJ IDEA (recomendado)

1. Abre el proyecto en IntelliJ IDEA.
2. Marca la carpeta `src/` como **Sources Root** (clic derecho → *Mark Directory as → Sources Root*) si no lo está.
3. Abre `ui/Main.java` y presiona el botón **Run** (o `Shift + F10`).

### Por línea de comandos (Mac / Linux con JDK completo)

```bash
# Desde la raíz del proyecto
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -Dstdout.encoding=UTF-8 -cp out ui.Main
```

### Nota sobre el PC con solo JRE

Si en el equipo no existe el binario `javac` (solo hay JRE), la compilación puede realizarse
mediante la **API `javax.tools`** con codificación UTF-8 (`-Dstdout.encoding=UTF-8`),
tal como se verificó este proyecto antes de la entrega.

---
