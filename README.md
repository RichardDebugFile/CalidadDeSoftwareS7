# Conversor de Unidades — Taller PDCA + TDD

Ejercicio 2 del Taller Práctico de Calidad de Software. Implementación de una calculadora de conversiones métricas aplicando el ciclo PDCA junto con la metodología TDD.

## Descripción

Calculadora que convierte entre metros, centímetros y milímetros. Cada conversión fue implementada por un integrante del grupo siguiendo un ciclo PDCA/TDD completo.

## Estructura del proyecto

```
CalidadDeSoftwareS7/
├── pom.xml
└── src/
    ├── main/java/
    │   └── ConversorUnidades.java      # Clase principal
    └── test/java/
        └── ConversorUnidadesTest.java  # Pruebas JUnit 5
```

## Métodos implementados

| Método | Conversión | Ciclo |
|--------|-----------|-------|
| `metrosACentimetros(double metros)` | 1 m = 100 cm | Ciclo 1 |
| `metrosAMilimetros(double metros)` | 1 m = 1000 mm | Ciclo 2 |
| `centimetrosAMilimetros(double centimetros)` | 1 cm = 10 mm | Ciclo 3 |
| `milimetrosAMetros(double milimetros)` | 1000 mm = 1 m | Ciclo 4 |

## Los 4 ciclos PDCA/TDD

### Ciclo 1 — `metrosACentimetros` (Integrante 1)

**Plan (Red):** Se escribe la prueba primero y se ejecuta esperando que falle.
```java
@Test
void unMetroEquivaleACienCentimetros() {
    assertEquals(100.0, conversor.metrosACentimetros(1.0), 0.0001);
}
```
`mvn test` → **FALLA** (el método no existe aún)

**Do (Green):** Se implementa el código mínimo.
```java
public double metrosACentimetros(double metros) {
    return metros * 100;
}
```
`mvn test` → **PASA**

**Check:** La prueba pasa. No hay pruebas anteriores que romper.

**Act (Refactor):** Sin cambios en este ciclo. Se continúa al siguiente.

---

### Ciclo 2 — `metrosAMilimetros` (Integrante 2)

**Plan (Red):**
```java
@Test
void unMetroEquivaleAMilMilimetros() {
    assertEquals(1000.0, conversor.metrosAMilimetros(1.0), 0.0001);
}
```
`mvn test` → **FALLA** (método no existe)

**Do (Green):**
```java
public double metrosAMilimetros(double metros) {
    return metros * 1000;
}
```
`mvn test` → **2 pruebas pasan**

**Check:** Ambas pruebas pasan. No se rompió el Ciclo 1.

**Act (Refactor):** Se introducen constantes para eliminar números mágicos.
```java
private static final double CM_POR_METRO = 100;
private static final double MM_POR_METRO = 1000;
```
`mvn test` → **Siguen verdes**

---

### Ciclo 3 — `centimetrosAMilimetros` (Integrante 3)

**Plan (Red):**
```java
@Test
void diezCentimetrosEquivalenACienMilimetros() {
    assertEquals(100.0, conversor.centimetrosAMilimetros(10.0), 0.0001);
}
```
`mvn test` → **FALLA**

**Do (Green):**
```java
public double centimetrosAMilimetros(double centimetros) {
    return centimetros * 10;
}
```
`mvn test` → **3 pruebas pasan**

**Act (Refactor):**
```java
private static final double MM_POR_CM = 10;
```

---

### Ciclo 4 — `milimetrosAMetros` (Integrante 4)

**Plan (Red):**
```java
@Test
void milMilimetrosEquivalenAUnMetro() {
    assertEquals(1.0, conversor.milimetrosAMetros(1000.0), 0.0001);
}
```
`mvn test` → **FALLA**

**Do (Green):**
```java
public double milimetrosAMetros(double milimetros) {
    return milimetros / 1000;
}
```
`mvn test` → **4 pruebas pasan**

**Act (Refactor):** Se reutiliza la constante existente.
```java
public double milimetrosAMetros(double milimetros) {
    return milimetros / MM_POR_METRO;
}
```
`mvn test` → **Siguen verdes**

---

## Resultado final de las pruebas

```
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## Comandos útiles

```bash
# Ejecutar todas las pruebas
mvn test

# Ejecutar una prueba específica
mvn -Dtest=ConversorUnidadesTest#unMetroEquivaleACienCentimetros test

# Compilar sin ejecutar pruebas
mvn compile
```

