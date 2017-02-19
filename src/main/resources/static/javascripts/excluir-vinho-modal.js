$('#confirmaExclusaoModal').on("show.bs.modal", function (event){
		var button = $(event.relatedTarget);
		var nome = button.data('nome');
		var url = button.data('url-apagar');
		var modal = $(this);
		var form = modal.find('form');
		form.attr('action', url);
		modal.find('.modal-body span').html('Tem certexa que deseja excluir o <strong>'+
			nome+'</strong>?');
});
