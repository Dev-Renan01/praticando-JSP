<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<jsp:include page="theme-loader.jsp"></jsp:include>

	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->

						<jsp:include page="page-header.jsp"></jsp:include>

						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">

										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-block">
														<h3 class="sub-title">Cadastro de Usuário</h3>

														<form class="form-material"
															action="<%=request.getContextPath()%>/ServletUsuarioController"
															method="post" id="formUser">

															<input type="hidden" name="acao" id="acao" value="">

															<div class="form-group form-default  form-static-label">
																<input type="text" name="id" id="id"
																	class="form-control" readonly="readonly"
																	value="${modelLogin.id}"> <span
																	class="form-bar"></span> <label class="float-label">Id:</label>
															</div>
															<div class="form-group form-default  form-static-label">
																<input type="text" name="nome" id="nome"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.nome}">
																<span class="form-bar"> </span> <label
																	class="float-label">Nome:</label>
															</div>
															<div class="form-group form-default  form-static-label">
																<input type="email" name="email" id="email"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.email}">
																<span class="form-bar"></span> <label
																	class="float-label">Email </label>
															</div>
															<div class="form-group form-default  form-static-label">
																<input type="text" name="login" id="login"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.login}">
																<span class="form-bar"></span> <label
																	class="float-label">Login </label>
															</div>
															<div class="form-group form-default  form-static-label">
																<input type="password" name="senha" id="senha"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.senha}">
																<span class="form-bar"></span> <label
																	class="float-label">Password</label>
															</div>

															<button
																class="btn waves-effect waves-light btn-grd-primary"
																onclick="limparForm();">Novo</button>
															<button
																class="btn waves-effect waves-light btn-grd-success">Salvar</button>
															<button type="button"
																class="btn waves-effect waves-light btn-grd-info "
																onclick="criarDeletar()">Excluir</button>
															<span>${msg}</span>

														</form>
													</div>
												</div>
											</div>
										</div>

									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="javascriptfile.jsp"></jsp:include>

	<script type="text/javascript">
	
	function criarDeletar(){

		if(confirm("Você deseja realmente excluir este usuário?")){
	
		document.getElementById("formUser").method = 'get';
		document.getElementById("acao").value = 'deletar';
		document.getElementById("formUser").submit();
		}
		
	}
	
	
	function limparForm() {

			var elementos = document.getElementById("formUser").elements; /*Retorna os elementos html dentro do form*/

			for (p = 0; p < elementos.length; p++) {
				elementos[p].value = '';
			}
		}
	</script>
</body>

</html>
