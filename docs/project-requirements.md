# My Day Book

## Description
Este proyecto tiene como objetivo desarrollar una plataforma de gestión personal orientada a mejorar la organización diaria y el seguimiento de hábitos. A través de una interfaz intuitiva, el usuario podrá planificar y registrar sus actividades diarias, realizar un seguimiento de sus hábitos, y reflexionar sobre su desempeño al final de cada día. El sistema no solo ayudará a los usuarios a organizar su tiempo, sino que también les permitirá identificar áreas de mejora y tomar decisiones informadas para optimizar su productividad, bienestar y desarrollo personal.

Con funcionalidades como la planificación de tareas, el registro de hábitos, y un sistema de reflexión y estadísticas personalizadas, la plataforma busca proporcionar a los usuarios una visión clara de su progreso y motivarlos a hacer cambios positivos en su vida diaria. Al conocer sus logros, errores y áreas de mejora, los usuarios podrán ajustar sus comportamientos y tomar el control de su vida cotidiana de manera efectiva y consciente.

## Problema a resolver
El problema a resolver en este proyecto es la falta de organización y seguimiento efectivo de las actividades diarias y hábitos personales, lo que dificulta la productividad y el bienestar de las personas. Muchas personas luchan por gestionar su tiempo de manera eficiente, no tienen claridad sobre qué actividades están mejorando su vida y carecen de un sistema para reflexionar sobre su progreso. Esto conduce a una falta de motivación, procrastinación y, en muchos casos, a una sensación de estancamiento. Este proyecto busca proporcionar una solución que permita a los usuarios planificar, hacer seguimiento y reflexionar sobre sus hábitos y actividades, facilitando la toma de decisiones informadas para mejorar su vida diaria.

## Descripción de la funcionalidad de la aplicación
La aplicación web permite a los usuarios registrarse e iniciar sesión mediante correo electrónico y contraseña, o a través de su cuenta de Google. Al ingresar, los usuarios verán todas las actividades programadas para el día, con opciones para agregar nuevas tareas, especificando detalles como hora, descripción, prioridad y fecha límite. Las tareas pueden marcarse como completadas y filtrarse por estado (pendientes, completadas o todas).

Los usuarios también podrán crear y gestionar hábitos, tanto diarios como semanales (por ejemplo: leer, hacer ejercicio, meditar), y registrar su progreso. A través de un "termómetro emocional", los usuarios podrán registrar cómo se sienten cada día, generando reportes sobre la evolución de su estado emocional a lo largo del tiempo.

Cada día, la plataforma permitirá a los usuarios escribir reflexiones en su diario personal, registrando cómo fue su día y qué aprendieron. Las reflexiones se guardan para su revisión futura.

La aplicación contará con una sección de estadísticas visuales donde los usuarios podrán ver qué hábitos y actividades han realizado con mayor frecuencia en un periodo de tiempo seleccionado, así como el tiempo dedicado a cada actividad. Las estadísticas se presentan en gráficos interactivos para ayudar a los usuarios a identificar patrones y áreas de mejora.

Los usuarios podrán programar actividades y hábitos para días futuros, visualizándolos en un calendario interactivo. Además, podrán revisar actividades y reflexiones de días pasados. Cada día también tendrá un álbum de imágenes donde los usuarios podrán agregar fotos que representen momentos importantes o recuerdos, con la opción de añadir notas descriptivas.

La interfaz de la aplicación será completamente personalizable, permitiendo a los usuarios elegir entre diferentes esquemas de colores o crear uno propio para adaptarlo a sus preferencias.

La plataforma incluirá notificaciones automáticas para recordar a los usuarios sobre actividades pendientes o hábitos olvidados, y brindará la opción de sincronizar los datos entre diferentes dispositivos, permitiendo a los usuarios acceder a su información desde cualquier lugar.

### Lista de requisitos funcionales

#### 1. Registro e inicio de sesión

- Los usuarios deben poder registrarse mediante correo electrónico y contraseña.
- Los usuarios también pueden registrarse/iniciar sesión mediante una cuenta de Google.
- El sistema debe permitir la recuperación de la contraseña en caso de olvido.


#### 2. Gestión de tareas
- Los usuarios deben poder crear tareas, especificando:
    - Nombre de la tarea.
    - Descripción de la tarea.
    - Hora y fecha de vencimiento.
    - Prioridad (baja, media, alta).
- Los usuarios deben poder marcar las tareas como completadas.
- Los usuarios deben poder filtrar las tareas por estado: pendientes, completadas, o todas.
- Los usuarios deben poder editar o eliminar tareas.

#### 3. Gestión de hábitos:
- Los usuarios deben poder crear hábitos diarios y semanales (ejemplo: leer, hacer ejercicio, meditar).
- Los usuarios deben poder registrar su progreso diario en los hábitos (completado/no completado).
- Los usuarios deben poder editar o eliminar hábitos.

#### 4. Termómetro emocional:
- Los usuarios deben poder registrar cómo se sienten cada día, seleccionando un estado emocional de una lista predefinida (puede ser un emoji, colores o una escala numérica).
- El sistema debe generar un reporte de la evolución del estado emocional del usuario a lo largo del tiempo.

#### 5. Reflexiones y Diario:
- Los usuarios deben poder escribir reflexiones sobre su día en un espacio de diario.
- Las reflexiones deben ser guardadas y accesibles en cualquier momento.
- El sistema debe permitir que los usuarios editen o eliminen las reflexiones.

#### 6. Estadísticas:
- Los usuarios deben poder visualizar estadísticas sobre su progreso, tales como:
    - Actividades realizadas más frecuentemente.
    - Tiempo dedicado a cada actividad.
    - Hábitos completados durante un periodo seleccionado.
- Las estadísticas deben presentarse en gráficos interactivos (barras, líneas, etc.).
- Los usuarios deben poder seleccionar el periodo de tiempo para las estadísticas (diario, semanal, mensual).

#### 7. Calendario y programación:
- Los usuarios deben poder programar actividades y hábitos para días futuros.
- Los usuarios deben poder ver todas las actividades programadas en un calendario interactivo.
- Los usuarios no deben poder modificar las actividades de días pasados.

#### 8. Álbum de imágenes:
- Los usuarios deben poder agregar imágenes al álbum de cada día.
- Las imágenes pueden estar acompañadas de una descripción o nota.
- Los usuarios deben poder eliminar o modificar las imágenes añadidas.

#### 9. Personalización de la interfaz:
- Los usuarios deben poder elegir entre esquemas de colores predefinidos o crear un esquema propio.
- Los cambios de personalización deben reflejarse en la interfaz inmediatamente.

#### 10. Notificaciones:
- Los usuarios deben recibir notificaciones para recordarles actividades pendientes o hábitos olvidados.
- Los usuarios deben poder gestionar las notificaciones (activar/desactivar).