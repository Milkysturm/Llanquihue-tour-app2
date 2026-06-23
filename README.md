![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# Llanquihue Tour – Jerarquías de Clases con Herencia Simple (Semana 6)

## Autor del proyecto
- **Nombre completo:** Olga Rivas Ahumada
- **Carrera:** Analista Programador Computacional
- **Asignatura:** Desarrollo Orientado a Objetos I

---

## Objetivo de esta semana

En esta sexta semana se incorpora **herencia simple** al sistema de Llanquihue Tour. El objetivo es representar jerárquicamente los distintos **tipos de servicios turísticos** que ofrece la agencia (rutas gastronómicas, paseos lacustres y excursiones culturales), reutilizando los atributos comunes desde una superclase y especializando cada subclase con su propio atributo distintivo.

> **Nota conceptual:** esta nueva jerarquía (`ServicioTuristico` y sus subclases) es **independiente** de la clase `Tour` trabajada en semanas anteriores. `Tour` aplica **composición** (un tour "tiene un" guía, un proveedor y un operador), mientras que `ServicioTuristico` aplica **herencia** (una ruta gastronómica "es un" servicio turístico). Ambos modelos conviven en el mismo proyecto como ejercicios independientes de POO.

---

## Descripción general del sistema

**Llanquihue Tour** es una agencia de turismo de la Región de Los Lagos que necesita una estructura flexible para modelar distintos servicios turísticos que comparten información básica (nombre y duración), pero que también requieren atributos propios según su categoría, permitiendo a futuro ampliar el sistema con nuevos tipos de servicios sin duplicar código.

Este proyecto consolida todo el trabajo de semanas anteriores (lectura de archivos, colecciones, composición) y agrega una jerarquía de herencia simple sobre los mismos fundamentos.

---

## Estructura del proyecto

El código se organiza en paquetes funcionales que separan responsabilidades:

```plaintext
📁 src/
├── model/        # Clases del dominio
│   ├── Tour.java                # (Semana 5) Tour: CONTIENE Guia, Proveedor y Operador (composición)
│   ├── Guia.java                # (Semana 5) Guía turístico asignado al tour
│   ├── Proveedor.java           # (Semana 5) Proveedor de transporte del tour
│   ├── Operador.java            # (Semana 5) Operador local del tour
│   ├── ServicioTuristico.java   # (Semana 6) Superclase: nombre y duracionHoras
│   ├── RutaGastronomica.java    # (Semana 6) extends ServicioTuristico + numeroDeParadas
│   ├── PaseoLacustre.java       # (Semana 6) extends ServicioTuristico + tipoEmbarcacion
│   └── ExcursionCultural.java   # (Semana 6) extends ServicioTuristico + lugarHistorico
├── util/         # Librería de utilidades propia
│   └── Validador.java           # (Semana 5) Métodos estáticos de validación reutilizables
├── service/      # Lógica de negocio sobre Tour
│   └── GestorTours.java         # (Semana 5) Lee tours.txt, crea objetos y realiza búsquedas
├── data/         # Lógica de negocio sobre ServicioTuristico
│   └── GestorServicios.java     # (Semana 6) Lee servicios.txt y crea instancias de cada subclase
├── ui/           # Punto de entrada
│   └── Main.java                # Ejecuta ambos flujos (tours y servicios) y muestra resultados
└── resources/    # Recursos del proyecto
    ├── tours.txt                 # (Semana 5) Archivo de datos de tours (11 campos por línea)
    └── servicios.txt             # (Semana 6) Archivo de datos de servicios turísticos (4 campos por línea)
```

---

## Clases creadas o modificadas esta semana

| Clase | Paquete | Rol en el sistema |
|-------|---------|-------------------|
| `ServicioTuristico` | `model` | **Superclase** de la nueva jerarquía. Define los atributos comunes `nombre` y `duracionHoras`, con sus getters, setters validados y `toString()`. |
| `RutaGastronomica` | `model` | **Subclase** que extiende `ServicioTuristico`, agregando `numeroDeParadas`. Usa `super(...)` en su constructor y sobrescribe `toString()`. |
| `PaseoLacustre` | `model` | **Subclase** que extiende `ServicioTuristico`, agregando `tipoEmbarcacion`. Usa `super(...)` en su constructor y sobrescribe `toString()`. |
| `ExcursionCultural` | `model` | **Subclase** que extiende `ServicioTuristico`, agregando `lugarHistorico`. Usa `super(...)` en su constructor y sobrescribe `toString()`. |
| `GestorServicios` | `data` | Lee `servicios.txt`, identifica el tipo de subclase indicado en cada línea y crea la instancia correspondiente. |
| `Main` | `ui` | *(Actualizada)* Ahora ejecuta dos flujos: el catálogo de `Tour` (Semana 5) y el listado de `ServicioTuristico` (Semana 6). |

### Clases que se mantienen sin cambios (semanas anteriores)

| Clase | Paquete | Rol en el sistema |
|-------|---------|-------------------|
| `Tour` | `model` | Representa un tour y **contiene** un `Guia`, un `Proveedor` y un `Operador` (composición triple). |
| `Guia` / `Proveedor` / `Operador` | `model` | Colaboradores que componen un `Tour`. |
| `Validador` | `util` | Librería propia con métodos estáticos de validación. |
| `GestorTours` | `service` | Lee `tours.txt` y ofrece búsquedas por tipo, nombre y precio. |

### Conceptos aplicados esta semana

- **Herencia simple:** `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` heredan de `ServicioTuristico` mediante `extends`.
- **Uso de `super(...)`:** cada subclase invoca el constructor de la superclase para inicializar los atributos comunes.
- **Sobrescritura de métodos (`@Override`):** cada subclase sobrescribe `toString()`, reutilizando `super.toString()` y agregando su atributo propio.
- **Organización por responsabilidad:** el proyecto separa `model` (dominio), `data` (acceso a datos de servicios), `service` (acceso a datos de tours), `util` (utilidades) y `ui` (interfaz de consola).
- **Composición (semana anterior):** se mantiene en `Tour`, que contiene `Guia`, `Proveedor` y `Operador`.

---

## Formato del archivo `servicios.txt`

Cada línea sigue el formato `nombre;duracionHoras;tipoSubclase;atributoEspecifico`:

```
Ruta del Queso Llanquihue;4;RutaGastronomica;6
Navegacion Lago Llanquihue;5;PaseoLacustre;Lancha
Ruta de los Volcanes;6;ExcursionCultural;Fuerte de Niebla
```

El cuarto campo cambia de significado según el tipo de subclase indicado en el tercer campo (número de paradas, tipo de embarcación o lugar histórico).

---

## Instrucciones para compilar y ejecutar

### Requisitos
- Java JDK 17 o superior (recomendado JDK 21).
- Si solo se cuenta con el JRE (sin `javac` como binario), compilar usando la API `javax.tools` desde un archivo auxiliar, tal como se documentó en semanas anteriores.

### Compilar y ejecutar desde la terminal

```bash
# Desde la carpeta raíz del proyecto (LlanquihueTourApp)
javac -d out -encoding UTF-8 $(find src -name "*.java")
java -Dstdout.encoding=UTF-8 -cp out ui.Main
```

> **Importante:** se recomienda forzar la codificación UTF-8 (`-encoding UTF-8` al compilar y `-Dstdout.encoding=UTF-8` al ejecutar) para que tildes y la letra "ñ" se muestren correctamente en consola.

### Ejecutar desde IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. Ubicar la clase `Main` dentro del paquete `ui`.
3. Ejecutar con clic derecho → **Run 'Main.main()'**.

---

## Salida esperada por consola (resumen)

```
==========================================
 LLANQUIHUE TOUR - CATALOGO DE TOURS
==========================================

--- Catálogo completo de tours (6) ---

Tour: Ruta del Queso Llanquihue | Tipo: Gastronomico | Precio: $25000.0 | Cupos: 15
   -> Guía: Marcela Soto | Idioma: Espanol | Experiencia: 6 años
   -> Proveedor: Transportes Lago Azul | Transporte: Bus
   -> Operador: Agroturismo Sur | Comuna: Llanquihue

[... resto del catálogo y búsquedas de Tour ...]

==========================================
 LLANQUIHUE TOUR - SERVICIOS TURISTICOS
 (Jerarquia de herencia)
==========================================

--- Listado de servicios turísticos (6) ---

Servicio: Ruta del Queso Llanquihue | Duración: 4 horas | Tipo: Ruta Gastronómica | Paradas: 6
Servicio: Sabores del Lago | Duración: 3 horas | Tipo: Ruta Gastronómica | Paradas: 3
Servicio: Navegacion Lago Llanquihue | Duración: 5 horas | Tipo: Paseo Lacustre | Embarcación: Lancha
Servicio: Atardecer en el Llanquihue | Duración: 3 horas | Tipo: Paseo Lacustre | Embarcación: Velero
Servicio: Ruta de los Volcanes | Duración: 6 horas | Tipo: Excursión Cultural | Lugar histórico: Fuerte de Niebla
Servicio: Historias de Puerto Varas | Duración: 4 horas | Tipo: Excursión Cultural | Lugar histórico: Casa Yunge
```

---

## Historial de versiones del proyecto

| Semana | Foco principal |
|--------|----------------|
| Semana 3 | Modelo base de personas (`Persona`, `Direccion`, `Empleado`) con encapsulamiento. |
| Semana 4 | Lectura de archivo `tours.txt`, `ArrayList<Tour>`, filtros por tipo/precio/disponibilidad. |
| Semana 5 | Reorganización en 4 paquetes, composición triple (`Tour` con `Guia`, `Proveedor`, `Operador`), librería `Validador`, validaciones con `IllegalArgumentException`. |
| **Semana 6** | **Jerarquía de herencia simple** (`ServicioTuristico` y subclases), nuevo paquete `data`, archivo `servicios.txt`. |
