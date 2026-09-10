



SpringEduManager/
├── src/main/java/com/edumanager/
│   ├── SpringEduManagerApplication.java    <-- Clase principal con @SpringBootApplication
│   │
│   ├── config/                             <-- Configuración global
│   │   └── SecurityConfig.java            <-- Configuración de Spring Security y roles (Lección 4)
│   │
│   ├── controller/                         <-- Controladores web (MVC - Lección 2)
│   │   ├── EstudianteController.java      <-- Rutas para vistas de Estudiante
│   │   ├── CursoController.java           <-- Rutas para vistas de Curso
│   │   └── AuthController.java            <-- Control de Login y Logout
│   │
│   ├── controller/api/                     <-- Servicios API REST (Lección 5)
│   │   ├── EstudianteRestController.java  <-- Endpoints REST CRUD Estudiantes[cite: 1]
│   │   └── CursoRestController.java       <-- Endpoints REST CRUD Cursos[cite: 1]
│   │
│   ├── model/                              <-- Entidades JPA (Lección 2 y 3)[cite: 1]
│   │   ├── Estudiante.java
│   │   ├── Curso.java
│   │   └── Evaluacion.java
│   │
│   ├── repository/                         <-- Repositorios JPA (Lección 3)[cite: 1]
│   │   ├── EstudianteRepository.java      <-- Extiende JpaRepository[cite: 1]
│   │   └── CursoRepository.java           <-- Extiende JpaRepository[cite: 1]
│   │
│   └── service/                            <-- Capa de Lógica de Negocio (Lección 3)[cite: 1]
│       ├── EstudianteService.java
│       ├── CursoService.java
│       └── impl/
│           ├── EstudianteServiceImpl.java
│           └── CursoServiceImpl.java
│
├── src/main/resources/
│   ├── static/                             <-- Archivos estáticos
│   │   ├── css/                           <-- Hojas de estilo
│   │   ├── js/                            <-- Scripts JS
│   │   └── images/                        <-- Recursos gráficos[cite: 1]
│   │
│   ├── templates/                          <-- Vistas Thymeleaf/HTML (Lección 2)[cite: 1]
│   │   ├── auth/
│   │   │   └── login.html                 <-- Formulario de login (Lección 4)[cite: 1]
│   │   ├── estudiantes/
│   │   │   ├── lista.html                 <-- Listado de estudiantes[cite: 1]
│   │   │   └── formulario.html            <-- Formulario de registro/edición[cite: 1]
│   │   ├── cursos/
│   │   │   ├── lista.html                 <-- Listado de cursos[cite: 1]
│   │   │   └── formulario.html            <-- Carga de cursos (Solo ADMIN)[cite: 1]
│   │   └── index.html                     <-- Página principal
│   │
│   └── application.properties              <-- Conexión H2/MySQL y Spring Security[cite: 1]
│
├── src/test/java/com/edumanager/           <-- Pruebas unitarias/integración
└── pom.xml                                 <-- Dependencias Maven (Lección 1)[cite: 1]