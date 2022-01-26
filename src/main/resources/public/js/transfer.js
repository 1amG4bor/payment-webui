function accountNumberFormatter(event) {
    var newNumber = event.data.replace(/[^0-9]/g, '')
    var accountNumber = event.currentTarget.value
        .slice(0, -1)
        .replaceAll("-", '')
        .concat(newNumber);

    var splitter = new RegExp(/.{1,8}/g)
    var parts = accountNumber.match(splitter)
    event.currentTarget.value = parts.join("-");
}
