const index = {
  init: function() {
    const _this = this;
    $('#btn-create').on('click', function() {
      _this.createPost();
    })
  },
  createPost: function() {
    const data = {
      title: $('#title').val(),
      author: $('#author').val(),
      content: $('#content').val()
    };

    $.ajax({
      type: 'POST',
      url: '/api/v1/posts',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      data: JSON.stringify(data)
    }).done(function() {
      alert('게시글이 정상적으로 등록되었습니다.');
      window.location.href = '/';
    }).fail(function(error) {
      alert(JSON.stringify(error));
    })
  }
};
index.init();