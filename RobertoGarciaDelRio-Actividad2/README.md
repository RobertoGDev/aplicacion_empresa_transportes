# Sistema de Gestión de Transportes - Actividad 2

**Autor:** Roberto García Del Río  
**Proyecto:** Actividad 2 - Programación - Gestión de Transportes

## 📋 Descripción del Proyecto

Este proyecto implementa un sistema completo de gestión de transportes que permite administrar rutas, vehículos y empleados de una empresa de transporte. El sistema está desarrollado en Java utilizando programación orientada a objetos con herencia, polimorfismo e interfaces.

## 🏗️ Arquitectura del Sistema

El proyecto sigue el patrón **MVC (Modelo-Vista-Controlador)** y está organizado en las siguientes capas:

### 📁 Estructura de Directorios

```
src/
├── Modelo/
│   ├── javabean/          # Clases de modelo (entidades)
│   │   ├── Vehiculo.java      # Clase abstracta base
│   │   ├── Camion.java        # Implementación para camiones
│   │   ├── Furgoneta.java     # Implementación para furgonetas
│   │   ├── Empleado.java      # Datos de empleados
│   │   └── Ruta.java          # Información de rutas
│   └── negocio/           # Lógica de negocio
│       ├── IGestionRutas.java # Interfaz de gestión
│       └── GestionRutas.java  # Implementación de la gestión
└── Testing/               # Clases de prueba
    ├── TestGestionRutas.java
    └── TestHerencia.java
```

## 🚛 Componentes Principales

### 1. **Modelo de Vehículos** (Jerarquía con Herencia)

#### `Vehiculo` (Clase Abstracta)
- **Propiedades:** matrícula, marca, modelo, kilómetros totales, consumo
- **Métodos abstractos:**
  - `cargaDisponible()`: Calcula la carga disponible
  - `getPorcentajeCarga()`: Obtiene el porcentaje de carga
  - `isLleno()`: Verifica si está lleno

#### `Camion` (Extends Vehiculo)
- **Características específicas:**
  - Capacidad de carga en kg
  - Carga ocupada en kg
  - Número de ejes
- **Funcionalidad:** Transporte de mercancías pesadas

#### `Furgoneta` (Extends Vehiculo)
- **Características específicas:**
  - Volumen de carga en m³
  - Volumen ocupado en m³
- **Funcionalidad:** Transporte de paquetes y mercancías ligeras

### 2. **Modelo de Empleados**

#### `Empleado`
- **Propiedades:** DNI, nombre, apellidos, email, género
- **Funcionalidad:** Gestión de conductores asignados a rutas

### 3. **Modelo de Rutas**

#### `Ruta`
- **Propiedades:**
  - ID único, fecha, origen, destino
  - Vehículo usado, empleado asignado
  - Kilómetros recorridos, carga transportada
- **Métodos principales:**
  - `isCargaCorrecta()`: Valida que la carga no exceda la capacidad
  - `getOrigenDestino()`: Formato de ruta completa
  - `tipoRuta()`: Clasifica rutas (CORTA/MEDIA/LARGA)
  - `calcularConsumoEstimado()`: Estima el combustible necesario

### 4. **Gestión de Negocio**

#### `IGestionRutas` (Interfaz)
Define las operaciones del sistema:
- Agregar y eliminar rutas
- Consultar rutas por empleado/vehículo/destino
- Estadísticas de kilómetros por vehículo
- Filtros por intervalos de fechas

#### `GestionRutas` (Implementación)
- **Gestión completa de rutas:** CRUD operations
- **Datos de prueba:** Sistema preconfigurado con 16 rutas
- **Consultas avanzadas:** Filtros y agrupaciones
- **Estadísticas:** Análisis de uso por tipo de vehículo

## ⚡ Funcionalidades Principales

### 🔍 **Consultas y Filtros**
- ✅ Rutas por empleado (DNI)
- ✅ Rutas por vehículo (matrícula)
- ✅ Rutas por destino
- ✅ Rutas en intervalo de fechas
- ✅ Kilómetros totales por vehículo
- ✅ Kilómetros totales por tipo de vehículo

### 📊 **Análisis y Estadísticas**
- ✅ Clasificación de rutas por distancia
- ✅ Cálculo de consumo estimado
- ✅ Verificación de capacidad de carga
- ✅ Porcentajes de ocupación de vehículos

### 🛠️ **Gestión de Datos**
- ✅ Agregar nuevas rutas
- ✅ Eliminar rutas (por objeto o ID)
- ✅ Validaciones de integridad
- ✅ Carga de datos de prueba

## 🚀 Cómo Ejecutar el Proyecto

### Prerrequisitos
- Java JDK 8 o superior
- IDE compatible (Eclipse, IntelliJ, VS Code)

### Pasos para Ejecutar

1. **Clonar el repositorio:**
```bash
git clone <url-del-repositorio>
cd RobertoGarciaDelRio-Actividad2
```

2. **Importar en tu IDE:**
   - Abrir el proyecto como proyecto Java existente
   - Verificar que el classpath esté configurado correctamente

3. **Ejecutar las pruebas:**
   - Clase principal: `Testing.TestGestionRutas`
   - Descomenta los métodos de test que quieras ejecutar

### Ejemplo de Ejecución

```java
public static void main(String[] args) {
    // Descomenta los métodos que quieras probar
    testVerRutas();
    testAddRuta();
    testRutasPorEmpleado();
    testTotalKmPorVehiculo();
}
```

## 📝 Datos de Prueba Incluidos

El sistema incluye datos preconfigurados:

- **5 Camiones:** Diferentes marcas (MAN, DAF, Mercedes) con capacidades variadas
- **4 Furgonetas:** Modelos diversos (Iveco, Volkswagen, Mercedes, Peugeot)
- **4 Empleados:** Conductores con información completa
- **16 Rutas:** Recorridos por toda España con fechas 2025-2026

## 🎯 Casos de Uso Principales

### 1. **Gestión de Flota**
```java
// Consultar rutas de un vehículo específico
List<Ruta> rutasCamion = gestion.rutasPorVehiculo("4634FRT");
```

### 2. **Control de Empleados**
```java
// Ver todas las rutas de un empleado
List<Ruta> rutasEmpleado = gestion.rutasPorEmpleado("56232425b");
```

### 3. **Análisis de Rendimiento**
```java
// Estadísticas de uso por tipo de vehículo
Map<String, Long> kmPorTipo = gestion.totalKmPorTipoVehiculo();
```

### 4. **Planificación de Rutas**
```java
// Filtrar rutas por período
List<Ruta> rutasDiciembre = gestion.rutasIntervaloFechas(
    LocalDate.of(2025, 12, 1), 
    LocalDate.of(2025, 12, 31)
);
```

## 🔧 Extensibilidad del Sistema

El diseño permite fácil extensión:

- **Nuevos tipos de vehículos:** Implementar la clase abstracta `Vehiculo`
- **Más funcionalidades:** Agregar métodos a la interfaz `IGestionRutas`
- **Validaciones adicionales:** Extender los métodos de validación en `Ruta`
- **Nuevos reportes:** Implementar en la clase `GestionRutas`

## 🧪 Testing

El proyecto incluye clases de testing comprehensivas:

- `TestGestionRutas.java`: Pruebas de todas las funcionalidades
- `TestHerencia.java`: Verificación de la jerarquía de clases

## 📚 Conceptos Aplicados

### Programación Orientada a Objetos
- ✅ **Herencia:** Jerarquía Vehiculo → Camion/Furgoneta
- ✅ **Polimorfismo:** Métodos abstractos implementados diferentemente
- ✅ **Encapsulación:** Propiedades privadas con getters/setters
- ✅ **Abstracción:** Interfaces y clases abstractas

### Estructuras de Datos
- ✅ **ArrayList:** Gestión de colecciones de rutas
- ✅ **HashMap:** Agrupaciones y estadísticas
- ✅ **LocalDate:** Manejo de fechas moderno

### Patrones de Diseño
- ✅ **Repository Pattern:** Gestión centralizada de datos
- ✅ **Strategy Pattern:** Diferentes comportamientos por tipo de vehículo

## 👨‍💻 Autor

**Roberto García Del Río**  
Estudiante de Desarrollo de Aplicaciones Web  
Actividad 2 - Programación - Gestión de Transportes

---

*Este proyecto forma parte de las actividades académicas del módulo de Programación, demostrando competencias en POO, estructuras de datos y diseño de software en Java.*