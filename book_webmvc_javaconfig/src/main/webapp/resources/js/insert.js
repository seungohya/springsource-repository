


const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
  // 코드 필드가 4자리의 숫자인지 확인
  const code = document.querySelector('#code');
  if (!/^\d{4}$/.test(code.value)) {
    window.alert('코드는 4자리의 숫자이어야 합니다.');
    event.preventDefault();
    return;
  }

  // 모든 필드가 채워져있는지 확인
  const title = document.querySelector('#title');
  const writer = document.querySelector('#writer');
  const price = document.querySelector('#price');
  if (title.value === '' || writer.value === '' || price.value === '') {
    window.alert('모든 필드는 채워져 있어야 합니다.');
    event.preventDefault();
    return;
  }

  // 가격 필드가 숫자인지 확인
  const priceValue = parseInt(price.value);
  if (isNaN(priceValue)) {
    window.alert('가격은 숫자여야 합니다.');
    event.preventDefault();
    return;
  }
});
