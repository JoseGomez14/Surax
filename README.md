# Surax



## Propósito

Está es una aplicación que se encarga de la gestión de las pólizas de la empresa Surax, tanto en su modelo particular, como en los modelos vehiculares y estudiantiles.

El software se encarga de almacenar, solicitar y gestionar la información necesaria para la adquisición de pólizas, está enfocado en que un operario de la compañía sea el encargado del manejo de dicha aplicación.
Este aplicativo tiene la capacidad de calcular los costos, beneficios, descuentos y devoluciones óptimas para cada caso particular tomando en cuenta una amplia variedad de parámetros.


## Elementos previos al desarrollo

En el ciclo del desarrollo se hacen necesarios otros tipos de consideraciones previas a la acción de codificar una aplicación que hacen parte de toda la planificación necesaria para llevar a cabo un proyecto, teniendo esto en cuenta se diseñado un diagrama de clases y unos *mockups* (Que dadas las limitaciones del lenguaje en interfaces graficas no se pudo seguir tal como se planteó) para esclarecer el flujo de trabajo:

-	Diagrama: https://drive.google.com/file/d/1YhAVe1v1xRH3Oyz_qnZlXSkMOIg_ertM/view?usp=sharing
-	Mockup: https://www.figma.com/file/enqqoaALARx6VwduUAoqrA/Surax---Main?node-id=0%3A1

Además, se han usado algunas herramientas que atienden al flujo de trabajo de metodologías agiles, como *Trello*, chats de comunicación, aplicativos de videoconferencias, *figma*, etc.


## Información de desarrollo

Esta aplicación fue diseñada con el objetivo de aplicar los conocimientos adquiridos en el transcurso del curso *Técnicas de programación y laboratorio* de la Universidad de Antioquia y que esta dirigido por la profesora Diana Margot López.

Es proyecto ha sido desarrollado por los siguientes estudiantes de Ingeniería de Sistemas de la Universidad de Antioquia:

-	Jose David Gómez M.
-	Hector Andrés Güíza O.
-	Luis David Martínez G.

La aplicación se ha desarrollado bajo el paradigma objetual o también conocido como la programación orientada a objetos (POO), usando el lenguaje de programación *JAVA* en su versión *Standard Edition*, y el patrón de diseño *MVC (Modelo – vista – controlador)*.


  ### Interfaz gráfica
  
  Para la interfaz gráfica de la aplicación se ha hecho uso de la librería *Java Swing* que proporciona los elementos gráficos necesarios para mostrar información generada desde el código en un ambiente gráfico. Aunque sus componentes no son muy modernos si tienen una amplia lista de propiedades que permiten modificarlos y también un manejo de eventos completo que permitió mejorar la interactividad en el uso de la aplicación.
  
  
  ### Almacenamiento de información
  
  Para almacenar los datos de la aplicación se ha hecho uso de los métodos para guardar información en *RAM* lo que implica que los datos se guardarán mientras el programa permanezca activo y cada vez que esté se inicie los campos estarán en blanco.
  
  Se han usado variables, vectores, *ArrayList*, *HashMap* para guardar los datos necesarios para realizar las operaciones, y los datos que el usuario podrá seleccionar desde cajas de selección están almacenados en documentos que contienen la información obtenida desde fuentes afines a los datos requeridos.


  ### Seguridad
  
  Se ha tomado el supuesto de que esté software está creado como *Software Cerrado* y de uso exclusivo para la compañía prestadora del servició, pero si se quisiera proteger aún más y escalar con otros sistemas de información se podría generar un control de sesión por operario, donde se ingrese una clave y contraseña y el programa valide y cargue la información necesaria.
