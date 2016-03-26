
  <form role ="form" id="main_input_box">
    <label>
      <div class="task-info">
        <label>Task: </label><input type="text" class="form-control task_js" id="custom_textbox" name="Item">
      </div>
      <div class="alert-danger todoError_js" style="display: none"></div>
      <div class="priority-info" style="margin-top: 10px;">
        <label>Priority</label>
        <div class="select-style">
          <select class="priority_js">
            <option value="">-- Nothing selected --</option>
            <option value="0">High</option>
            <option value="1">Medium</option>
            <option value="2">Low</option>
          </select>
        </div>
      </div>
      <div class="alert-danger priorityError_js" style="display: none"></div>
      <div class="submit-info" style="margin-top: 10px">
        <input type="button" value="Save new Todo" class="btn btn-primary add_button submit_js">
      </div>
    </label>
  </form>
  <form>
  </form>