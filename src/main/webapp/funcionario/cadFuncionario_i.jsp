<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="label.titulo.pagina.cadastro" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">
	<s:include value="/includes/topMenu.jsp" />
	<div class="container">
		<s:form action="/novoFuncionarios.action">
			<div class="card mt-5">
				<div class="card-header">
					<div class="row">
						<div class="col-sm-5">
							<s:url action="todosFuncionarios" var="todos" />
							<a href="${todos}" class="btn btn-success">
								Funcionarios
							</a>
						</div>
						<div class="col-sm">
							<h5 class="card-title">
								Novo Funcionário
							</h5>
						</div>
					</div>		
				</div>
				
				<div class="card-body">
					<div class="row align-items-center">
						<label for="id" class="col-sm-1 col-form-label text-center">
							Código:
						</label>
						
						<div class="col-sm-2">
							<s:textfield cssClass="form-control" id="id" name="funcionarioVo.rowid" readonly="true" />
						</div>
					</div>
					
					<div class="row align-items-center mt-3">
						<label for="nome" class="col-sm-1 col-form-label ext-center">
							Nome:
						</label> 
						
						<div class="col-sm-5">
							<s:textfield cssClass="form-control" id="nome" name="funcionarioVo.nome" />
						</div>
					</div>
				</div>
				
				<div class="card-footer">
					<div class="form-row">
						<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
						<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulário</button>
					</div>
				</div>
			</div>
			
		</s:form>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>