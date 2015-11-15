
<%@ page import="semaforo.Vehiculo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehiculo.label', default: 'Vehiculo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vehiculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vehiculo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="vehiculo.seguro.label" default="Seguro" /></th>
					
						<g:sortableColumn property="placa" title="${message(code: 'vehiculo.placa.label', default: 'Placa')}" />
					
						<g:sortableColumn property="marca" title="${message(code: 'vehiculo.marca.label', default: 'Marca')}" />
					
						<g:sortableColumn property="tipoVehiculo" title="${message(code: 'vehiculo.tipoVehiculo.label', default: 'Tipo Vehiculo')}" />
					
						<g:sortableColumn property="referencia1" title="${message(code: 'vehiculo.referencia1.label', default: 'Referencia1')}" />
					
						<g:sortableColumn property="referencia2" title="${message(code: 'vehiculo.referencia2.label', default: 'Referencia2')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${vehiculoInstanceList}" status="i" var="vehiculoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${vehiculoInstance.id}">${fieldValue(bean: vehiculoInstance, field: "seguro")}</g:link></td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "placa")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "marca")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "tipoVehiculo")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "referencia1")}</td>
					
						<td>${fieldValue(bean: vehiculoInstance, field: "referencia2")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${vehiculoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
