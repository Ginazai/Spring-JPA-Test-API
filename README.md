<h1>SpringBoot REST API</h1>
<p>API REST de comercio electronico desarrollada en SpringBoot implementando SpringSecurity y JWT para la gestion de autenticacion.</p>
<h2>Tecnologias utilizadas</h2>
<p>El proyecto fue desarrollado utilizando las siguientes tecnologias:</p>
<ul>
	<li>JavaSE-1.8</li>
	<li>SpringBoot 3.4.5</li>
	<li>Spring Security 6.2.0</li>
	<li>Listado de dependencias en <code>pom.xml</code></li>
	
</ul>
<p>Frontend desarrollado en ReactJS, con una aplicacion de ejemplo que consume la API REST utilizando las siguientes tecnologias:</p>
<ul>
	<li><code>npm</code> 10.3.0</li>
	<li>react 19.1.0</li>
	<li>react-app 1.1.2</li>
	<li>Listado de dependencias en <code>package.json</code></li>
</ul>
<h2>Instalacion</h2>
Las instrucciones de instalacion son especificamente para el entorno en el que fue desarrollado el proyecto (Eclipe IDE).
<ol>
	<li>Desde <b>Eclipse Marketplace</b> instale <b>Spring Tools (aka Spring Tool Suite) 4.30.0</b>.</li>
	<li>Instale MS SQL Server 2019.</li>
	<li>Instale <b>SQL Server Management Studio 20</b> para facilitar la gestion de la base de datos.</li>
	<ul>
		<li>Alternativamente se puede utilizar otra base de datos, pero se debera configurar la dependencia en el <code>pom.xml</code> asi como la configuracion en <code>application.properties</code>.</li>
	</ul>
	<li>Ajuste las configuraciones del usuario y contrase&ntilde;a en <code>application.properties</code> segun lo configurado en MS SQL Server.</li>
</ol>
<p>El proyecto contiene los queries utilizados en SQL Server en la carpeta <code>SQLServerQueries</code>, especificamente:</p>
<ol>
	<li>Un archivo <code>.txt</code> para flexibilidad de uso.</li>
	<li>5 archivos (del 0 al 4) enumerados por orden de uso.</li>
	<li><b>Importante: </b>El ultimo query debe ser ejecutado luego de ejecutar <code>POST register</code> en la coleccion de <b>Postman</b> para conferir los permisos administrativos al usuario recien registrado</li>
</ol>
<ul>
	<li>Adicionalmente se incluye una coleccion de <b>Postman</b> (<code>Outputs API.postman_collection.json</code>) que puede ser cargada para ejecutarse de manera automatica.</li>
</ul>


