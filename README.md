# 🚀 Viaje Interplanetario

## Historia de Usuario

### US-001: Calcular Tiempo de Viaje Interplanetario

**Como** un explorador espacial  
**Quiero** calcular el tiempo de viaje a diferentes planetas del sistema solar  
**Para** planificar mis misiones interplanetarias de manera eficiente y optimizar el uso de recursos

#### Descripción
Este programa permite a los usuarios seleccionar un planeta destino del sistema solar y calcular el tiempo estimado de viaje basándose en la distancia desde la Tierra y la velocidad de la nave espacial.

#### Criterios de Aceptación
- ✅ El sistema debe mostrar una lista de planetas disponibles del sistema solar
- ✅ El usuario debe poder seleccionar un planeta de la lista
- ✅ El sistema debe validar que el planeta seleccionado sea válido
- ✅ El sistema debe solicitar la velocidad de la nave espacial en km/h
- ✅ El sistema debe calcular y mostrar el tiempo estimado de viaje en horas
- ✅ El sistema debe mostrar la distancia al planeta seleccionado en kilómetros
- ✅ El sistema debe manejar entradas inválidas y solicitar nuevamente el destino

#### Características Implementadas
- Selección de planetas del sistema solar (Mercurio, Venus, Tierra, Marte, Júpiter, Saturno, Urano, Neptuno)
- Cálculo de tiempo de viaje basado en distancia y velocidad
- Validación de entrada del usuario con mensajes de error claros
- Interfaz de línea de comandos simple e intuitiva
- Conversión automática de distancias a kilómetros

#### Ejemplo de Uso
```
Bienvenido al programa de planificación de viaje interplanetario.
Selecciona un destino:
Mercurio
Venus
Tierra
Marte
Júpiter
Saturno
Urano
Neptuno
Marte
Distancia a Marte: 78300000.0 km
Ingresa la velocidad de la nave en km/h: 50000
El tiempo estimado de viaje es: 1566.0 horas.
```

---

## 📚 Ejercicios de Git

Este proyecto incluye ejercicios prácticos para aprender los comandos fundamentales de Git.

### Comandos a Practicar
- `git add` - Agregar archivos al área de staging
- `git commit` - Guardar cambios en el repositorio
- `git branch` - Trabajar con ramas
- `git remote` - Gestionar repositorios remotos
- `git push` - Enviar cambios al repositorio remoto
- `git status` - Ver el estado del repositorio
- `git log` - Ver el historial de commits
- `git clone` - Clonar un repositorio
- `.gitignore` - Ignorar archivos específicos

### Instrucciones de Uso
1. Sigue los ejercicios en el archivo `EJERCICIOS_GIT.md`
2. Practica cada comando paso a paso
3. Verifica tu progreso con `git status` y `git log`

---

## 🛠️ Compilación y Ejecución

```bash
javac ViajeInterplanetario.java
java ViajeInterplanetario
```

---

## 📝 Licencia
Este proyecto es educativo y está disponible para fines de aprendizaje.

