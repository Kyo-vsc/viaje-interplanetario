# 📖 Ejercicios Prácticos de Git

Este documento contiene ejercicios paso a paso para dominar los comandos fundamentales de Git.

---

## 📋 Pre-requisitos

1. Tener Git instalado en tu sistema
2. Tener una cuenta en GitHub
3. Tener este repositorio clonado o inicializado

---

## 🎯 Ejercicio 1: git status

**Objetivo:** Aprender a ver el estado actual del repositorio

### Pasos:
1. Abre tu terminal en la carpeta del proyecto
2. Ejecuta: `git status`
3. Observa qué archivos están:
   - Sin seguimiento (untracked)
   - Modificados (modified)
   - En staging (staged)

### Resultado esperado:
Deberías ver que `ViajeInterplanetario.java` está sin seguimiento o modificado.

---

## 🎯 Ejercicio 2: git add

**Objetivo:** Agregar archivos al área de staging

### Pasos:
1. Agrega un solo archivo: `git add ViajeInterplanetario.java`
2. Verifica el estado: `git status`
3. Agrega todos los archivos: `git add .`
4. Verifica nuevamente: `git status`

### Comandos:
```bash
git add ViajeInterplanetario.java
git status
git add .
git status
```

### Resultado esperado:
Los archivos deberían aparecer como "Changes to be committed" (cambios listos para commit).

---

## 🎯 Ejercicio 3: git commit

**Objetivo:** Guardar cambios en el historial del repositorio

### Pasos:
1. Haz un commit con mensaje: `git commit -m "Inicial: programa de viaje interplanetario"`
2. Verifica el log: `git log --oneline`
3. Haz una modificación pequeña en el código
4. Agrega y haz commit: `git add . && git commit -m "Mejora: actualización del código"`

### Comandos:
```bash
git commit -m "Inicial: programa de viaje interplanetario"
git log --oneline
# Edita el archivo Java
git add .
git commit -m "Mejora: actualización del código"
```

### Resultado esperado:
Deberías ver tus commits en el historial con `git log`.

---

## 🎯 Ejercicio 4: git log

**Objetivo:** Explorar el historial de commits

### Pasos:
1. Ver log completo: `git log`
2. Ver log resumido: `git log --oneline`
3. Ver log con gráfico: `git log --oneline --graph`
4. Ver últimos 3 commits: `git log -3 --oneline`

### Comandos:
```bash
git log
git log --oneline
git log --oneline --graph
git log -3 --oneline
```

### Resultado esperado:
Deberías ver el historial de todos tus commits con sus mensajes y fechas.

---

## 🎯 Ejercicio 5: git branch

**Objetivo:** Trabajar con ramas (branches)

### Pasos:
1. Ver ramas existentes: `git branch`
2. Crear una nueva rama: `git branch desarrollo`
3. Cambiar a la nueva rama: `git checkout desarrollo`
4. Verificar en qué rama estás: `git branch`
5. Crear y cambiar a una rama en un comando: `git checkout -b feature/nueva-funcionalidad`
6. Volver a main: `git checkout main`
7. Ver todas las ramas: `git branch -a`

### Comandos:
```bash
git branch
git branch desarrollo
git checkout desarrollo
git branch
git checkout -b feature/nueva-funcionalidad
git checkout main
git branch -a
```

### Resultado esperado:
Deberías poder crear, listar y cambiar entre diferentes ramas.

---

## 🎯 Ejercicio 6: git remote

**Objetivo:** Gestionar repositorios remotos

### Pasos:
1. Ver remotos configurados: `git remote -v`
2. Si no hay remoto, agrega uno:
   - Primero crea un repositorio en GitHub
   - Luego: `git remote add origin https://github.com/TU_USUARIO/viaje-interplanetario.git`
3. Verificar el remoto: `git remote -v`
4. Cambiar la URL del remoto (si es necesario): `git remote set-url origin NUEVA_URL`
5. Ver información del remoto: `git remote show origin`

### Comandos:
```bash
git remote -v
git remote add origin https://github.com/TU_USUARIO/viaje-interplanetario.git
git remote -v
git remote show origin
```

### Resultado esperado:
Deberías ver tu repositorio remoto configurado correctamente.

---

## 🎯 Ejercicio 7: git push

**Objetivo:** Enviar cambios al repositorio remoto

### Pasos:
1. Verifica que tengas commits locales: `git log --oneline`
2. Envía la rama main: `git push -u origin main`
3. Si trabajaste en otra rama, envíala: `git push -u origin desarrollo`
4. Verifica en GitHub que tus cambios estén ahí

### Comandos:
```bash
git log --oneline
git push -u origin main
git push -u origin desarrollo
```

### Resultado esperado:
Tus commits deberían aparecer en GitHub.

---

## 🎯 Ejercicio 8: git clone

**Objetivo:** Clonar un repositorio existente

### Pasos:
1. Ve a otra carpeta (fuera del proyecto actual)
2. Clona el repositorio: `git clone https://github.com/TU_USUARIO/viaje-interplanetario.git`
3. Entra a la carpeta clonada: `cd viaje-interplanetario`
4. Verifica el estado: `git status`
5. Ver el log: `git log --oneline`

### Comandos:
```bash
cd ..
git clone https://github.com/TU_USUARIO/viaje-interplanetario.git
cd viaje-interplanetario
git status
git log --oneline
```

### Resultado esperado:
Deberías tener una copia completa del repositorio en una nueva ubicación.

---

## 🎯 Ejercicio 9: .gitignore

**Objetivo:** Ignorar archivos que no deben ser rastreados

### Pasos:
1. Verifica que existe `.gitignore`: `cat .gitignore` (o `type .gitignore` en Windows)
2. Compila el programa Java: `javac ViajeInterplanetario.java`
3. Verifica el estado: `git status`
4. Observa que `ViajeInterplanetario.class` NO aparece (está ignorado)
5. Si quisieras agregar un archivo específico a ignorar, edita `.gitignore`

### Comandos:
```bash
cat .gitignore
javac ViajeInterplanetario.java
git status
```

### Resultado esperado:
Los archivos `.class` y otros archivos compilados no deberían aparecer en `git status`.

---

## 🎯 Ejercicio 10: Flujo Completo

**Objetivo:** Practicar todo el flujo de trabajo

### Pasos:
1. Crea una nueva rama: `git checkout -b ejercicio-completo`
2. Haz una modificación en el código
3. Verifica el estado: `git status`
4. Agrega los cambios: `git add .`
5. Haz commit: `git commit -m "Ejercicio: flujo completo de trabajo"`
6. Ver el log: `git log --oneline -3`
7. Envía la rama: `git push -u origin ejercicio-completo`
8. Vuelve a main: `git checkout main`
9. Fusiona la rama (opcional): `git merge ejercicio-completo`
10. Envía los cambios: `git push origin main`

### Comandos:
```bash
git checkout -b ejercicio-completo
# Edita ViajeInterplanetario.java
git status
git add .
git commit -m "Ejercicio: flujo completo de trabajo"
git log --oneline -3
git push -u origin ejercicio-completo
git checkout main
git merge ejercicio-completo
git push origin main
```

### Resultado esperado:
Deberías haber completado todo el ciclo de trabajo con Git.

---

## 📝 Notas Adicionales

### Comandos Útiles Adicionales:
- `git diff` - Ver diferencias entre archivos
- `git reset` - Deshacer cambios en staging
- `git checkout -- archivo` - Descartar cambios en un archivo
- `git pull` - Traer cambios del remoto
- `git fetch` - Traer información del remoto sin fusionar

### Buenas Prácticas:
1. Haz commits frecuentes con mensajes descriptivos
2. Usa ramas para nuevas funcionalidades
3. Siempre verifica `git status` antes de hacer commit
4. Mantén tu `.gitignore` actualizado
5. Haz push regularmente para respaldar tu trabajo

---

## ✅ Checklist de Completitud

- [ ] Ejercicio 1: git status
- [ ] Ejercicio 2: git add
- [ ] Ejercicio 3: git commit
- [ ] Ejercicio 4: git log
- [ ] Ejercicio 5: git branch
- [ ] Ejercicio 6: git remote
- [ ] Ejercicio 7: git push
- [ ] Ejercicio 8: git clone
- [ ] Ejercicio 9: .gitignore
- [ ] Ejercicio 10: Flujo completo

---

¡Felicitaciones! Has completado todos los ejercicios de Git. 🎉

